package com.dev.api.request;

public class GetDrawResultRequest {

	private boolean kenoOrIlotto; // true is keno, false is lotto
	private String gameCode;
	private String market;
	private String drawDate;
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

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(String drawDate) {
		this.drawDate = drawDate;
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
		builder.append("GetDrawResultRequest [kenoOrIlotto=").append(kenoOrIlotto).append(", gameCode=")
				.append(gameCode).append(", market=").append(market).append(", drawDate=").append(drawDate)
				.append(", beginDate=").append(beginDate).append(", endDate=").append(endDate).append(", pageIndex=")
				.append(pageIndex).append(", merchantCode=").append(merchantCode).append(", serialNo=").append(serialNo)
				.append("]");
		return builder.toString();
	}

}
