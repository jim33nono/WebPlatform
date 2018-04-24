package com.dev.api.response;

public class BetInfoLotto {
	private String drawDate;
	private double payout;
	private String status;
	private int multiple;
	private double netAmt;
	private String prizeGroup;
	private double comm;
	private long prize;
	private long ticketId;
	private String acctId;
	private String betTime;
	private int betAmount;
	private String gameCode;
	private String market;
	private String drawNumber;
	private String betType;
	private String betChoice;
	private String result;
	private String resultTime;
	private double winLoss;
	private String currency;
	private int betUnit;
	private int betCount;
	private String betIp;
	private boolean cancelled;
	

	public String getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(String drawDate) {
		this.drawDate = drawDate;
	}

	public double getPayout() {
		return payout;
	}

	public void setPayout(double payout) {
		this.payout = payout;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public double getNetAmt() {
		return netAmt;
	}

	public void setNetAmt(double netAmt) {
		this.netAmt = netAmt;
	}
	
	public String getPrizeGroup() {
		return prizeGroup;
	}

	public void setPrizeGroup(String prizeGroup) {
		this.prizeGroup = prizeGroup;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public long getPrize() {
		return prize;
	}

	public void setPrize(long prize) {
		this.prize = prize;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getBetTime() {
		return betTime;
	}

	public void setBetTime(String betTime) {
		this.betTime = betTime;
	}

	public int getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(int betAmount) {
		this.betAmount = betAmount;
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

	public String getBetType() {
		return betType;
	}

	public void setBetType(String betType) {
		this.betType = betType;
	}

	public String getBetChoice() {
		return betChoice;
	}

	public void setBetChoice(String betChoice) {
		this.betChoice = betChoice;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultTime() {
		return resultTime;
	}

	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}

	public double getWinLoss() {
		return winLoss;
	}

	public void setWinLoss(double winLoss) {
		this.winLoss = winLoss;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getBetUnit() {
		return betUnit;
	}

	public void setBetUnit(int betUnit) {
		this.betUnit = betUnit;
	}

	public int getBetCount() {
		return betCount;
	}

	public void setBetCount(int betCount) {
		this.betCount = betCount;
	}

	public String getBetIp() {
		return betIp;
	}

	public void setBetIp(String betIp) {
		this.betIp = betIp;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BetInfoLotto [payout=").append(payout).append(", status=").append(status).append(", multiple=")
				.append(multiple).append(", netAmt=").append(netAmt).append(", prizeGroup=").append(prizeGroup)
				.append(", comm=").append(comm).append(", prize=").append(prize).append(", ticketId=").append(ticketId)
				.append(", acctId=").append(acctId).append(", betTime=").append(betTime).append(", betAmount=")
				.append(betAmount).append(", gameCode=").append(gameCode).append(", market=").append(market)
				.append(", drawNumber=").append(drawNumber).append(", betType=").append(betType).append(", betChoice=")
				.append(betChoice).append(", result=").append(result).append(", resultTime=").append(resultTime)
				.append(", winLoss=").append(winLoss).append(", currency=").append(currency).append(", betUnit=")
				.append(betUnit).append(", betCount=").append(betCount).append(", betIp=").append(betIp)
				.append(", cancelled=").append(cancelled).append("]");
		return builder.toString();
	}


}
