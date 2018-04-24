package com.dev.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.model.bean.Transfer;
import com.dev.model.service.AcctCreditService;
import com.dev.model.service.TransferService;

@Controller
@RequestMapping("oneWallet")
public class TransferringHistoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransferringHistoryController.class);

	@Autowired
	private AcctCreditService acctCreditService;
	@Autowired
	private TransferService transferService;

	@RequestMapping(value = "/loadingHistory", method = RequestMethod.GET)
	@ResponseBody
	public List<Transfer> loadTransHistory() {
		List<Transfer> transferHistory = transferService.findAll();
		LOGGER.info(transferHistory.size() + " :size");
//		Transfer temp = transferHistory.get(0);
//		TransferringHistoryVo vo = new TransferringHistoryVo(temp.getTxId(), temp.getTransferId(), temp.getTicketId(),
//				temp.getAcctId(), temp.getAmount(), temp.getTransferType(), temp.getOperationTime());
//		List<TransferringHistoryVo> list = new ArrayList<TransferringHistoryVo>();
//		list.add(vo);
		return transferHistory;
	}

}
