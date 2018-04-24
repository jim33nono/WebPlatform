package com.dev.web.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TransferringHistoryVo {

	public TransferringHistoryVo() {
	}

	public TransferringHistoryVo(Long txId, String transferId, String ticketId, String acctId, BigDecimal amount,
			int transferType, Date operationTime) {
		this.txId = txId;
		this.transferId = transferId;
		this.ticketId = ticketId;
		this.acctId = acctId;
		this.amount = amount;
		this.transferType = transferType;
		this.operationTime = operationTime;
	}

	private Long txId;
	private String transferId;
	private String ticketId;
	private String acctId;
	private BigDecimal amount;
	private int transferType;
	private Date operationTime;

	public Long getTxId() {
		return txId;
	}

	public void setTxId(Long txId) {
		this.txId = txId;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getTransferType() {
		return transferType;
	}

	public void setTransferType(int transferType) {
		this.transferType = transferType;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransferringHistoryVo [txId=").append(txId).append(", transferId=").append(transferId)
				.append(", ticketId=").append(ticketId).append(", acctId=").append(acctId).append(", amount=")
				.append(amount).append(", transferType=").append(transferType).append(", operationTime=")
				.append(operationTime).append("]");
		return builder.toString();
	}

}
