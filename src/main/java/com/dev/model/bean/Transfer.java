package com.dev.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acct_transfer")
public class Transfer implements Serializable {

	private static final long serialVersionUID = -7517830749391497828L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tx_id")
	private Long txId;

	@Column(name = "transfer_id")
	private String transferId;

	@Column(name = "acct_id")
	private String acctId;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "curr_id")
	private String currId;

	@Column(name = "reference_id")
	private String referenceId;

	@Column(name = "transfer_type")
	private int transferType;

	@Column(name = "ticket_id")
	private String ticketId;

	@Column(name = "game")
	private String game;

	@Column(name = "status")
	private int status;

	@Column(name = "operation_time")
	private Date operationTime;

	@Column(name = "call_api_request")
	private String apiReqJson;
	
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

	public String getCurrId() {
		return currId;
	}

	public void setCurrId(String currId) {
		this.currId = currId;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public int getTransferType() {
		return transferType;
	}

	public void setTransferType(int transferType) {
		this.transferType = transferType;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public String getApiReqJson() {
		return apiReqJson;
	}

	public void setApiReqJson(String apiReqJson) {
		this.apiReqJson = apiReqJson;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transfer [txId=").append(txId).append(", transferId=").append(transferId).append(", acctId=")
				.append(acctId).append(", amount=").append(amount).append(", currId=").append(currId)
				.append(", referenceId=").append(referenceId).append(", transferType=").append(transferType)
				.append(", ticketId=").append(ticketId).append(", game=").append(game).append(", status=")
				.append(status).append(", operationTime=").append(operationTime).append(", apiReqJson=")
				.append(apiReqJson).append("]");
		return builder.toString();
	}
	


}
