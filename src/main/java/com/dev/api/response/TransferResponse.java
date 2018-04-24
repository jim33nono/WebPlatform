package com.dev.api.response;

import java.io.Serializable;

public class TransferResponse implements Serializable{
	
	private static final long serialVersionUID = -8788344541496989447L;
	private String transactionId;
	private String merchantCode;
	private int code;
	private String msg;
	private String serialNo;
	
	
	public TransferResponse() {
	}

	public TransferResponse(String transactionId, String merchantCode, int code, String msg, String serialNo) {
		this.transactionId = transactionId;
		this.merchantCode = merchantCode;
		this.code = code;
		this.msg = msg;
		this.serialNo = serialNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Override
	public String toString() {
		return "TransferResponse [transactionId=" + transactionId + ", merchantCode=" + merchantCode + ", code=" + code
				+ ", msg=" + msg + ", serialNo=" + serialNo + "]";
	}
	
	

}
