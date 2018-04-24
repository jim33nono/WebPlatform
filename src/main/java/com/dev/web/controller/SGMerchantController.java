package com.dev.web.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.api.request.Common;
import com.dev.auth.AcctInfo;
import com.dev.auth.AuthorizeResponse;
import com.dev.model.bean.AcctCredit;
import com.dev.model.bean.Transfer;
import com.dev.model.service.AcctCreditService;
import com.dev.model.service.TransferService;
import com.dev.onewallet.request.GetBalanceRequest;
import com.dev.onewallet.request.OneWalletTransferRequest;
import com.dev.onewallet.response.GetBalanceResponse;
import com.dev.onewallet.response.OneWalletTransferResponse;
import com.dev.util.CountUtil;
import com.google.common.base.Optional;

@Controller
@PropertySource("classpath:authorizeUrlAndRes.properties")
public class SGMerchantController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SGMerchantController.class);

	@Autowired
	private Environment env;
	@Autowired
	private AcctCreditService acctCreditService;

	@Autowired
	private TransferService transferService;

	@RequestMapping(value = "/accountAuth", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Object accountAuth(@RequestHeader String api, @RequestBody Map<String, String> request) {
		LOGGER.info("method: {}", api);
		if (Common.AUTHORIZE.equals(api)) {
			LOGGER.info(" /accountAuth.do post request catched");
			LOGGER.info(request.toString());
			AuthorizeResponse authorizeResponse = null;
			if (("SGTEST").equals(request.get("merchantCode"))) {
				Optional<AcctCredit> acctCredit = acctCreditService.findByAcctId(
						request.get("acctId"), request.get("merchantCode"));
				if (!acctCredit.isPresent()) {
					LOGGER.info("AcctId not found");
					return authorizeResponse = new AuthorizeResponse(Common.FAIL_CODE, Common.ACCT_NONEXISTENT);
				}
				AcctInfo defaultAcc = new AcctInfo();
				defaultAcc.setAcctId(request.get("acctId"));
				defaultAcc.setUserName(acctCredit.get().getAcctName());
				defaultAcc.setCurrency(acctCredit.get().getCurrency());
				defaultAcc.setBalance(acctCredit.get().getBalAmt());
				authorizeResponse = new AuthorizeResponse(Common.SUCCESS_CODE, Common.SUCCESS_MESSAGE,
						request.get("merchantCode"), defaultAcc);
			} else {
				AcctInfo defaultAcc = new AcctInfo();
				defaultAcc.setAcctId(env.getProperty("auth.account.acctId.test"));
				defaultAcc.setUserName(env.getProperty("auth.account.userName.test"));
				defaultAcc.setCurrency(env.getProperty("auth.account.currency.test"));
				defaultAcc.setBalance(new BigDecimal(Integer.parseInt(env.getProperty("auth.account.balance.test"))));
				authorizeResponse = new AuthorizeResponse(Common.SUCCESS_CODE, Common.SUCCESS_MESSAGE,
						env.getProperty("auth.merchantCode.test"), defaultAcc);
			}
			return authorizeResponse;

		} else if (Common.GET_BALANCE.equals(api)) {
			LOGGER.info(request.toString());
			GetBalanceRequest getBalanceRequest = new GetBalanceRequest(request.get("acctId"),
					request.get("merchantCode"), request.get("serialNo"));
			LOGGER.info(getBalanceRequest.toString());
			Optional<AcctCredit> optionalAcctInfo = acctCreditService.findByAcctId(getBalanceRequest.getAcctId(),
					getBalanceRequest.getMerchantCode());
			if (optionalAcctInfo.isPresent()) {
				LOGGER.info(optionalAcctInfo.toString());
				AcctCredit acctCredit = optionalAcctInfo.get();
				AcctInfo acctInfo = new AcctInfo(acctCredit.getAcctId(), acctCredit.getAcctName(),
						acctCredit.getCurrency(), CountUtil.calculateBalance(acctCredit.getBalAmt(),
								acctCredit.getPenAmt(), acctCredit.getBetAmt()));
				GetBalanceResponse getBalanceResponse = new GetBalanceResponse(acctInfo, request.get("merchantCode"),
						Common.SUCCESS_MESSAGE, Common.SUCCESS_CODE, request.get("serialNo"));

				return getBalanceResponse;
			} else {
				return new GetBalanceResponse(request.get("merchantCode"), Common.ACCT_NONEXISTENT, Common.FAIL_CODE,
						request.get("serialNo"));
			}

		} else if (Common.TRANSFER.equals(api)) {
			LOGGER.info(request.toString());
			OneWalletTransferRequest oneWalletTransferRequest = new OneWalletTransferRequest(
					Integer.valueOf(request.get("type")), request.get("currency"), request.get("acctId"),
					request.get("gameCode"), new BigDecimal(request.get("amount")), request.get("ticketId"),
					request.get("transferId"), request.get("merchantCode"), request.get("serialNo"));
			if (request.get("cancelId") != null) {
				oneWalletTransferRequest.setCancelId(request.get("cancelId"));
			}
			if (request.get("referenceId") != null) {
				oneWalletTransferRequest.setReferenceId(request.get("referenceId"));
			}
			LOGGER.info(oneWalletTransferRequest.toString());
			try {
				if (("1").equals(request.get("type"))) {
					Transfer transfer = new Transfer();
					transfer.setTransferId(oneWalletTransferRequest.getTransferId());
					transfer.setAcctId(oneWalletTransferRequest.getAcctId());
					transfer.setAmount(oneWalletTransferRequest.getAmount());
					transfer.setCurrId(oneWalletTransferRequest.getCurrency());
					transfer.setTransferType(oneWalletTransferRequest.getType());
					transfer.setTicketId(oneWalletTransferRequest.getTicketId());
					transfer.setGame(oneWalletTransferRequest.getGameCode());
					transfer.setOperationTime(new Date());
					transfer.setApiReqJson(request.toString());

					Optional<AcctCredit> acctCredit = acctCreditService.findByAcctId(
							oneWalletTransferRequest.getAcctId(), oneWalletTransferRequest.getMerchantCode());
					if (!acctCredit.isPresent()) {
						LOGGER.info("AcctId not found");
						return new OneWalletTransferResponse(null, oneWalletTransferRequest.getTransferId(),
								oneWalletTransferRequest.getAcctId(), new BigDecimal(0), Common.FAIL_CODE);
					} else {

						transferService.addTransfer(transfer);
						LOGGER.info(acctCredit.get().toString());

						Optional<Transfer> transferDB = transferService.findByTransferId(transfer.getTransferId());
						LOGGER.info(transferDB.get().toString());

						acctCredit.get().setBalAmt(
								CountUtil.subtract(acctCredit.get().getBalAmt(), oneWalletTransferRequest.getAmount()));
						acctCreditService.updateAcctCredit(acctCredit.get());

						return new OneWalletTransferResponse(transferDB.get().getTxId().toString(),
								transferDB.get().getTransferId(), transferDB.get().getAcctId(),
								acctCredit.get().getBalAmt(), Common.SUCCESS_CODE);
					}

				} else if (("2").equals(request.get("type"))) {
					Transfer transfer = new Transfer();
					transfer.setTransferId(oneWalletTransferRequest.getTransferId());
					transfer.setAcctId(oneWalletTransferRequest.getAcctId());
					transfer.setAmount(oneWalletTransferRequest.getAmount());
					transfer.setCurrId(oneWalletTransferRequest.getCurrency());
					transfer.setReferenceId(oneWalletTransferRequest.getReferenceId());
					transfer.setTransferType(oneWalletTransferRequest.getType());
					transfer.setTicketId(oneWalletTransferRequest.getTicketId());
					transfer.setGame(oneWalletTransferRequest.getGameCode());
					transfer.setOperationTime(new Date());
					transfer.setApiReqJson(request.toString());

					Optional<AcctCredit> acctCredit = acctCreditService.findByAcctId(
							oneWalletTransferRequest.getAcctId(), oneWalletTransferRequest.getMerchantCode());
					if (!acctCredit.isPresent()) {
						LOGGER.info("AcctId not found");
						return new OneWalletTransferResponse(null, oneWalletTransferRequest.getTransferId(),
								oneWalletTransferRequest.getAcctId(), new BigDecimal(0), Common.FAIL_CODE);
					} else {

						transferService.addTransfer(transfer);
						LOGGER.info(acctCredit.get().toString());

						Optional<Transfer> transferDB = transferService.findByTransferId(transfer.getTransferId());
						LOGGER.info(transferDB.get().toString());

						acctCredit.get().setBalAmt(
								CountUtil.plus(acctCredit.get().getBalAmt(), oneWalletTransferRequest.getAmount()));
						acctCreditService.updateAcctCredit(acctCredit.get());

						return new OneWalletTransferResponse(transferDB.get().getTxId().toString(),
								transferDB.get().getTransferId(), transferDB.get().getAcctId(),
								acctCredit.get().getBalAmt(), Common.SUCCESS_CODE);
					}

				} else if (("4").equals(request.get("type"))) {
					Transfer transfer = new Transfer();
					transfer.setTransferId(oneWalletTransferRequest.getTransferId());
					transfer.setAcctId(oneWalletTransferRequest.getAcctId());
					transfer.setAmount(oneWalletTransferRequest.getAmount());
					transfer.setCurrId(oneWalletTransferRequest.getCurrency());
					transfer.setReferenceId(oneWalletTransferRequest.getCancelId());
					transfer.setTransferType(oneWalletTransferRequest.getType());
					transfer.setTicketId(oneWalletTransferRequest.getTicketId());
					transfer.setGame(oneWalletTransferRequest.getGameCode());
					transfer.setOperationTime(new Date());
					transfer.setApiReqJson(request.toString());

					Optional<AcctCredit> acctCredit = acctCreditService.findByAcctId(
							oneWalletTransferRequest.getAcctId(), oneWalletTransferRequest.getMerchantCode());
					if (!acctCredit.isPresent()) {
						LOGGER.info("AcctId not found");
						return new OneWalletTransferResponse(null, oneWalletTransferRequest.getTransferId(),
								oneWalletTransferRequest.getAcctId(), new BigDecimal(0), Common.FAIL_CODE);
					} else {

						transferService.addTransfer(transfer);
						LOGGER.info(acctCredit.get().toString());

						Optional<Transfer> transferDB = transferService.findByTransferId(transfer.getTransferId());
						LOGGER.info(transferDB.get().toString());

						acctCredit.get().setBalAmt(
								CountUtil.plus(acctCredit.get().getBalAmt(), oneWalletTransferRequest.getAmount()));
						acctCreditService.updateAcctCredit(acctCredit.get());

						return new OneWalletTransferResponse(transferDB.get().getTxId().toString(),
								transferDB.get().getTransferId(), transferDB.get().getAcctId(),
								acctCredit.get().getBalAmt(), Common.SUCCESS_CODE);
					}

				} else if (("5").equals(request.get("type"))) {
					Transfer transfer = new Transfer();
					transfer.setTransferId(oneWalletTransferRequest.getTransferId());
					transfer.setAcctId(oneWalletTransferRequest.getAcctId());
					transfer.setAmount(oneWalletTransferRequest.getAmount());
					transfer.setCurrId(oneWalletTransferRequest.getCurrency());
					transfer.setReferenceId(oneWalletTransferRequest.getCancelId());
					transfer.setTransferType(oneWalletTransferRequest.getType());
					transfer.setTicketId(oneWalletTransferRequest.getTicketId());
					transfer.setGame(oneWalletTransferRequest.getGameCode());
					transfer.setOperationTime(new Date());
					transfer.setApiReqJson(request.toString());

					Optional<AcctCredit> acctCredit = acctCreditService.findByAcctId(
							oneWalletTransferRequest.getAcctId(), oneWalletTransferRequest.getMerchantCode());
					if (!acctCredit.isPresent()) {
						LOGGER.info("AcctId not found");
						return new OneWalletTransferResponse(null, oneWalletTransferRequest.getTransferId(),
								oneWalletTransferRequest.getAcctId(), new BigDecimal(0), Common.FAIL_CODE);
					} else {

						transferService.addTransfer(transfer);
						LOGGER.info(acctCredit.get().toString());

						Optional<Transfer> transferDB = transferService.findByTransferId(transfer.getTransferId());
						LOGGER.info(transferDB.get().toString());

						acctCredit.get().setBalAmt(
								CountUtil.subtract(acctCredit.get().getBalAmt(), oneWalletTransferRequest.getAmount()));
						acctCreditService.updateAcctCredit(acctCredit.get());

						return new OneWalletTransferResponse(transferDB.get().getTxId().toString(),
								transferDB.get().getTransferId(), transferDB.get().getAcctId(),
								acctCredit.get().getBalAmt(), Common.SUCCESS_CODE);
					}

				} else {
					return new OneWalletTransferResponse(null, oneWalletTransferRequest.getTransferId(),
							oneWalletTransferRequest.getAcctId(), new BigDecimal(0), Common.FAIL_CODE);
				}
			} catch (Exception e) {
				LOGGER.error("Error {}", e);
				return new OneWalletTransferResponse(null, oneWalletTransferRequest.getTransferId(),
						oneWalletTransferRequest.getAcctId(), new BigDecimal(0), Common.FAIL_CODE);
			}

		} else {
			return new AuthorizeResponse(Common.FAIL_CODE, Common.API_NAME_UNSUPPORTED);
		}

	}

}
