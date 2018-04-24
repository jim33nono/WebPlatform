package com.dev.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acct_credit")
public class AcctCredit implements Serializable {

	private static final long serialVersionUID = -2543899235670613055L;

	@Id
	@Column(name = "acct_id", nullable = false)
	private String acctId;

	@Column(name = "acct_name")
	private String acctName;

	@Column(name = "curr_id")
	private String currency;

	@Column(name = "bal_amt")
	private BigDecimal balAmt;

	@Column(name = "pen_amt")
	private BigDecimal penAmt;

	@Column(name = "bet_amt")
	private BigDecimal betAmt;

	@Column(name = "wl")
	private BigDecimal wl;

	@Column(name = "cr_limit")
	private BigDecimal crLimit;

	@Column(name = "rm_limit")
	private BigDecimal rmLimit;

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getBalAmt() {
		return balAmt;
	}

	public void setBalAmt(BigDecimal balAmt) {
		this.balAmt = balAmt;
	}

	public BigDecimal getPenAmt() {
		return penAmt;
	}

	public void setPenAmt(BigDecimal penAmt) {
		this.penAmt = penAmt;
	}

	public BigDecimal getBetAmt() {
		return betAmt;
	}

	public void setBetAmt(BigDecimal betAmt) {
		this.betAmt = betAmt;
	}

	public BigDecimal getWl() {
		return wl;
	}

	public void setWl(BigDecimal wl) {
		this.wl = wl;
	}

	public BigDecimal getCrLimit() {
		return crLimit;
	}

	public void setCrLimit(BigDecimal crLimit) {
		this.crLimit = crLimit;
	}

	public BigDecimal getRmLimit() {
		return rmLimit;
	}

	public void setRmLimit(BigDecimal rmLimit) {
		this.rmLimit = rmLimit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AcctCredit [acctId=").append(acctId).append(", acctName=").append(acctName)
				.append(", currency=").append(currency).append(", balAmt=").append(balAmt).append(", penAmt=")
				.append(penAmt).append(", betAmt=").append(betAmt).append(", wl=").append(wl).append(", crLimit=")
				.append(crLimit).append(", rmLimit=").append(rmLimit).append("]");
		return builder.toString();
	}

}
