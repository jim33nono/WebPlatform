package com.dev.api.request;

import java.io.Serializable;

public class TransferRequest implements Serializable{
	
	private static final long serialVersionUID = -5473766748002184086L;
	private boolean kenoOrIlotto;  //true is keno, false is lotto
	private String acctId;
	private long amount;
	private String currency;
	private String merchantCode;
	private String serialNo;
	
	public TransferRequest() {};
	
	public TransferRequest(boolean kenoOrIlotto, String acctId, long amount, String currency, String merchantCode, String serialNo) {
		this.kenoOrIlotto = kenoOrIlotto;
		this.acctId = acctId;
		this.amount = amount;
		this.currency = currency;
		this.merchantCode = merchantCode;
		this.serialNo = serialNo;
		
	}
	
	public boolean isKenoOrIlotto() {
		return kenoOrIlotto;
	}

	public void setKenoOrIlotto(boolean kenoOrIlotto) {
		this.kenoOrIlotto = kenoOrIlotto;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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
		return "TransferRequest [kenoOrIlotto=" + kenoOrIlotto + ", acctId=" + acctId + ", amount=" + amount
				+ ", currency=" + currency + ", merchantCode=" + merchantCode + "]";
	}

	
}
