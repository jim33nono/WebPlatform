package com.dev.onewallet.response;

import com.dev.auth.AcctInfo;

public class GetBalanceResponse {

	public GetBalanceResponse() {
	}

	public GetBalanceResponse(String merchantCode, String msg, int code, String serialNo) {
		this.merchantCode = merchantCode;
		this.msg = msg;
		this.code = code;
		this.serialNo = serialNo;
	}

	public GetBalanceResponse(AcctInfo acctInfo, String merchantCode, String msg, int code, String serialNo) {
		this.acctInfo = acctInfo;
		this.merchantCode = merchantCode;
		this.msg = msg;
		this.code = code;
		this.serialNo = serialNo;
	}

	private AcctInfo acctInfo;
	private String merchantCode;
	private String msg;
	private int code;
	private String serialNo;

	public AcctInfo getAcctInfo() {
		return acctInfo;
	}

	public void setAcctInfo(AcctInfo acctInfo) {
		this.acctInfo = acctInfo;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
		builder.append("GetBalanceResponse [acctInfo=").append(acctInfo).append(", merchantCode=").append(merchantCode)
				.append(", msg=").append(msg).append(", code=").append(code).append(", serialNo=").append(serialNo)
				.append("]");
		return builder.toString();
	}
	
	

}
