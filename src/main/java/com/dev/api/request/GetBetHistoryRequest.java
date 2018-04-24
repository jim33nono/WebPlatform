package com.dev.api.request;

import java.io.Serializable;

public class GetBetHistoryRequest implements Serializable{

	private static final long serialVersionUID = 7194601073606948875L;
	public GetBetHistoryRequest() {
		
	};
	
	private boolean kenoOrIlotto;  //true is keno, false is lotto
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
		return "GetBetHistoryRequest [kenoOrIlotto=" + kenoOrIlotto + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", pageIndex=" + pageIndex + ", merchantCode=" + merchantCode + ", serialNo=" + serialNo
				+ "]";
	}
	
	
	
}
