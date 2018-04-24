package com.dev.api.request;

public class CheckAmountRequest {

	private boolean kenoOrIlotto; // true is keno, false is lotto
	private String acctId;
	private String beginDate;
	private String endDate;
	private int pageIndex;
	private String merchantCode;
	private String serialNo;

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

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
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
		builder.append("CheckAmountRequest [kenoOrIlotto=").append(kenoOrIlotto).append(", acctId=").append(acctId)
				.append(", beginDate=").append(beginDate).append(", endDate=").append(endDate).append(", pageIndex=")
				.append(pageIndex).append(", merchantCode=").append(merchantCode).append(", serialNo=").append(serialNo)
				.append("]");
		return builder.toString();
	}

}
