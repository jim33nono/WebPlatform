package com.dev.auth;

import java.io.Serializable;
import java.math.BigDecimal;

public class AcctInfo implements Serializable{

	private static final long serialVersionUID = -9209071490815408365L;
	
	public AcctInfo() {
	}

	public AcctInfo(String acctId, String userName, String currency, BigDecimal balance) {
		this.acctId = acctId;
		this.userName = userName;
		this.currency = currency;
		this.balance = balance;
	}

	private String acctId;
	private String userName;
	private String currency;
	private BigDecimal balance;

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AcctInfo [acctId=" + acctId + ", userName=" + userName + ", currency=" + currency + ", balance="
				+ balance + "]";
	}
	
	

}
