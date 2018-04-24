package com.dev.api.request;

public class GetAcctInfoRequest {
	
	public GetAcctInfoRequest() {
		
	}
	private boolean kenoOrIlotto;  //true is keno, false is lotto
	private String acctId;
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
		return "GetAcctInfoRequest [kenoOrIlotto=" + kenoOrIlotto + ", acctId=" + acctId + ", pageIndex=" + pageIndex
				+ ", merchantCode=" + merchantCode + ", serialNo=" + serialNo + "]";
	}
	
	
	
	

}
