package com.sapient.calculator;

public class Transaction {
	@Override
	public String toString() {
		return "Transaction [externalTransactionID=" + externalTransactionID + ", clientId=" + clientId
				+ ", securityId=" + securityId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", marketValue=" + marketValue + ", priority=" + priority + ", transactionFees="
				+ transactionFees + "]";
	}
	private String externalTransactionID;
    private String clientId;
    private String securityId;
    private Integer transactionType;
    private java.util.Date transactionDate;
    private Double marketValue;
    private Boolean priority;
    private Double transactionFees;
	public String getExternalTransactionID() {
		return externalTransactionID;
	}
	public void setExternalTransactionID(String externalTransactionID) {
		this.externalTransactionID = externalTransactionID;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public Integer getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}
	public java.util.Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(java.util.Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}
	public Boolean getPriority() {
		return priority;
	}
	public void setPriority(Boolean priority) {
		this.priority = priority;
	}
	public Double getTransactionFees() {
		return transactionFees;
	}
	public void setTransactionFees(Double transactionFees) {
		this.transactionFees = transactionFees;
	}
}
