package com.dev.api.response;

public class CheckStatusResponse {

	private int status;
	private String merchantCode;
	private int code;
	private String msg;
	private String serialNo;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
		StringBuilder builder = new StringBuilder();
		builder.append("CheckStatusResponse [status=").append(status).append(", merchantCode=").append(merchantCode)
				.append(", code=").append(code).append(", msg=").append(msg).append(", serialNo=").append(serialNo)
				.append("]");
		return builder.toString();
	}

}
