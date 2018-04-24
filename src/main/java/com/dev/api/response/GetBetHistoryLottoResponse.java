package com.dev.api.response;

import java.util.List;

public class GetBetHistoryLottoResponse {
	
	private List<BetInfoLotto> list;
	private int resultCount;
	private int pageCount;
	private String merchantCode;
	private int code;
	private String msg;
	private String serialNo;
	public List<BetInfoLotto> getList() {
		return list;
	}
	public void setList(List<BetInfoLotto> list) {
		this.list = list;
	}
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
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
		return "GetBetHistoryLottoResponse [list=" + list + ", resultCount=" + resultCount + ", pageCount=" + pageCount
				+ ", merchantCode=" + merchantCode + ", code=" + code + ", msg=" + msg + ", serialNo=" + serialNo + "]";
	}
	
	
	
	

}
