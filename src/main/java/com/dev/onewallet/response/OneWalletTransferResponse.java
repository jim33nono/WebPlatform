package com.dev.onewallet.response;

import java.math.BigDecimal;

public class OneWalletTransferResponse {

	public OneWalletTransferResponse() {
	}

	public OneWalletTransferResponse(String merchantTxId, String transferId, String acctId, BigDecimal balance, int code) {
		this.merchantTxId = merchantTxId;
		this.transferId = transferId;
		this.acctId = acctId;
		this.balance = balance;
		this.code = code;
	}

	private String merchantTxId;
	private String transferId;
	private String acctId;
	private BigDecimal balance;
	private int code;

	public String getMerchantTxId() {
		return merchantTxId;
	}

	public void setMerchantTxId(String merchantTxId) {
		this.merchantTxId = merchantTxId;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OneWalletTransferResponse [merchantTxId=").append(merchantTxId).append(", transferId=")
				.append(transferId).append(", acctId=").append(acctId).append(", balance=").append(balance)
				.append(", code=").append(code).append("]");
		return builder.toString();
	}

}
