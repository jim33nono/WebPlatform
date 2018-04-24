package com.dev.onewallet.request;

public class GetBalanceRequest {
	public GetBalanceRequest() {

	}

	public GetBalanceRequest(String acctId, String merchantCode, String serialNo) {
		this.acctId = acctId;
		this.merchantCode = merchantCode;
		this.serialNo = serialNo;
	}

	private String acctId;
	private String merchantCode;
	private String serialNo;

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
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
		builder.append("GetBalanceRequest [acctId=").append(acctId).append(", merchantCode=").append(merchantCode)
				.append(", serialNo=").append(serialNo).append("]");
		return builder.toString();
	}

}
