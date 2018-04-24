package com.dev.api.request;

public class CheckStatusRequest {

	private boolean kenoOrIlotto; // true is keno, false is lotto
	private String lastSerialNo;
	private String merchantCode;
	private String serialNo;

	public boolean isKenoOrIlotto() {
		return kenoOrIlotto;
	}

	public void setKenoOrIlotto(boolean kenoOrIlotto) {
		this.kenoOrIlotto = kenoOrIlotto;
	}

	public String getLastSerialNo() {
		return lastSerialNo;
	}

	public void setLastSerialNo(String lastSerialNo) {
		this.lastSerialNo = lastSerialNo;
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
		builder.append("CheckStatusRequest [kenoOrIlotto=").append(kenoOrIlotto).append(", lastSerialNo=")
				.append(lastSerialNo).append(", merchantCode=").append(merchantCode).append(", serialNo=")
				.append(serialNo).append("]");
		return builder.toString();
	}

}
