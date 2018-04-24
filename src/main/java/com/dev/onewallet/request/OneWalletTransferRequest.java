package com.dev.onewallet.request;

import java.math.BigDecimal;

public class OneWalletTransferRequest {

	public OneWalletTransferRequest() {
	}

	public OneWalletTransferRequest(int type, String currency, String acctId, String gameCode, BigDecimal amount,
			String ticketId, String transferId, String merchantCode, String serialNo) {
		this.type = type;
		this.currency = currency;
		this.acctId = acctId;
		this.gameCode = gameCode;
		this.amount = amount;
		this.ticketId = ticketId;
		this.transferId = transferId;
		this.merchantCode = merchantCode;
		this.serialNo = serialNo;
	}

	private int type;
	private String currency;
	private String acctId;
	private String gameCode;
	private BigDecimal amount;
	private String ticketId;
	private String transferId;
	private String referenceId;
	private String cancelId;
	private String merchantCode;
	private String serialNo;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getCancelId() {
		return cancelId;
	}

	public void setCancelId(String cancelId) {
		this.cancelId = cancelId;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OneWalletTransferRequest [type=").append(type).append(", currency=").append(currency)
				.append(", acctId=").append(acctId).append(", gameCode=").append(gameCode).append(", amount=")
				.append(amount).append(", ticketId=").append(ticketId).append(", transferId=").append(transferId)
				.append(", referenceId=").append(referenceId).append(", cancelId=").append(cancelId)
				.append(", merchantCode=").append(merchantCode).append(", serialNo=").append(serialNo).append("]");
		return builder.toString();
	}

	

}
