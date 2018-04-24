package com.dev.api.response;

public class BetInfo {
	
	private long ticketId;
	private String acctId;
	private String betTime;
	private double betAmount;
	private String gameCode;
	private String market;
	private String drawNumber;
	private String betType;
	private String betChoice;
	private String result;
	private String resultTime;
	private double winLoss;
	private String currency;
	private double betUnit;
	private int betCount;
	private double odds;
	private String betIp;
	private boolean cancelled;
	private String channel;
	
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
	public double getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(double betAmount) {
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
	public double getBetUnit() {
		return betUnit;
	}
	public void setBetUnit(double betUnit) {
		this.betUnit = betUnit;
	}
	public int getBetCount() {
		return betCount;
	}
	public void setBetCount(int betCount) {
		this.betCount = betCount;
	}
	public double getOdds() {
		return odds;
	}
	public void setOdds(double odds) {
		this.odds = odds;
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
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", acctId=" + acctId + ", betTime=" + betTime + ", betAmount="
				+ betAmount + ", gameCode=" + gameCode + ", market=" + market + ", drawNumber=" + drawNumber
				+ ", betType=" + betType + ", betChoice=" + betChoice + ", result=" + result + ", resultTime="
				+ resultTime + ", winLoss=" + winLoss + ", currency=" + currency + ", betUnit=" + betUnit
				+ ", betCount=" + betCount + ", odds=" + odds + ", betIp=" + betIp + ", cancelled=" + cancelled
				+ ", channel=" + channel + "]";
	}
	
	
	
	
}
