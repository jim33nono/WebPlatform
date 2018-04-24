package com.dev.api.response;

import java.util.List;

public class DrawResult {
	private long id;
	private String gameCode;
	private String market;
	private String drawNumber;
	private List<String> result;
	private String drawDate;
	private String officialSiteTime;
	private String resultTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getDrawNumber() {
		return drawNumber;
	}

	public void setDrawNumber(String drawNumber) {
		this.drawNumber = drawNumber;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	public String getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(String drawDate) {
		this.drawDate = drawDate;
	}

	public String getOfficialSiteTime() {
		return officialSiteTime;
	}

	public void setOfficialSiteTime(String officialSiteTime) {
		this.officialSiteTime = officialSiteTime;
	}

	public String getResultTime() {
		return resultTime;
	}

	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DrawResult [id=").append(id).append(", gameCode=").append(gameCode).append(", market=")
				.append(market).append(", drawNumber=").append(drawNumber).append(", result=").append(result)
				.append(", drawDate=").append(drawDate).append(", officialSiteTime=").append(officialSiteTime)
				.append(", resultTime=").append(resultTime).append("]");
		return builder.toString();
	}

}
