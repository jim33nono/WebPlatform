package com.dev.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant")
public class Merchant implements Serializable {

	private static final long serialVersionUID = -6600437642031874778L;

	@Id
	@Column(name = "merchant_code")
	private String merchantCode;

	@Column(name = "merchant_name")
	private String merchantName;

	@Column(name = "support_currency")
	private String supportCurrency;

	@Column(name = "default_limit_group")
	private String defaultLimitGroup;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "api_data_type")
	private String apiDataType;

	@Column(name = "is_one_wallet")
	private int isOneWallet;

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getSupportCurrency() {
		return supportCurrency;
	}

	public void setSupportCurrency(String supportCurrency) {
		this.supportCurrency = supportCurrency;
	}

	public String getDefaultLimitGroup() {
		return defaultLimitGroup;
	}

	public void setDefaultLimitGroup(String defaultLimitGroup) {
		this.defaultLimitGroup = defaultLimitGroup;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getApiDataType() {
		return apiDataType;
	}

	public void setApiDataType(String apiDataType) {
		this.apiDataType = apiDataType;
	}

	public int getIsOneWallet() {
		return isOneWallet;
	}

	public void setIsOneWallet(int isOneWallet) {
		this.isOneWallet = isOneWallet;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merchant [merchantCode=").append(merchantCode).append(", merchantName=").append(merchantName)
				.append(", supportCurrency=").append(supportCurrency).append(", defaultLimitGroup=")
				.append(defaultLimitGroup).append(", isActive=").append(isActive).append(", apiDataType=")
				.append(apiDataType).append(", isOneWallet=").append(isOneWallet).append("]");
		return builder.toString();
	}

}
