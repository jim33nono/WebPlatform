package com.dev.api.response;

public class AcctAmount {

	private String acctId;
	private double balance;
	private double winLoss;
	private double turnover;
	private double rolling;

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWinLoss() {
		return winLoss;
	}

	public void setWinLoss(double winLoss) {
		this.winLoss = winLoss;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public double getRolling() {
		return rolling;
	}

	public void setRolling(double rolling) {
		this.rolling = rolling;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AcctAmount [acctId=").append(acctId).append(", balance=").append(balance).append(", winLoss=")
				.append(winLoss).append(", turnover=").append(turnover).append(", rolling=").append(rolling)
				.append("]");
		return builder.toString();
	}

}
