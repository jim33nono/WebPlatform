package com.dev.api.response;

import java.util.List;

public class GetDrawResultResponse {

	private List<DrawResult> list;
	private int resultCount;
	private int pageCount;
	private String merchantCode;
	private int code;
	private String msg;
	private String serialNo;

	public List<DrawResult> getList() {
		return list;
	}

	public void setList(List<DrawResult> list) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("GetDrawResultResponse [list=").append(list).append(", resultCount=").append(resultCount)
				.append(", pageCount=").append(pageCount).append(", merchantCode=").append(merchantCode)
				.append(", code=").append(code).append(", msg=").append(msg).append(", serialNo=").append(serialNo)
				.append("]");
		return builder.toString();
	}

}
