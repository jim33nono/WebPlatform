package com.dev.auth;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

public class AuthorizeResponse implements Serializable {
	private static final long serialVersionUID = -2742730323453876892L;

	public AuthorizeResponse() {
		
	}
	public AuthorizeResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public AuthorizeResponse(int code, String msg, String merchantCode, AcctInfo acctInfo) {
		this.code = code;
		this.msg = msg;
		this.merchantCode = merchantCode;
		this.acctInfo = acctInfo;
	}

	private int code;
	private String msg;
	private String merchantCode;
	private String serialNo;
	private AcctInfo acctInfo;

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

	public AcctInfo getAcctInfo() {
		return acctInfo;
	}

	public void setAcctInfo(AcctInfo acctInfo) {
		this.acctInfo = acctInfo;
	}

	@Override
	public String toString() {
		return "AuthorizeResponse [code=" + code + ", msg=" + msg + ", merchantCode=" + merchantCode + ", serialNo="
				+ serialNo + ", acctInfo=" + acctInfo + "]";
	}
	
	

}
