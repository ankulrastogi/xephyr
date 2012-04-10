package com.own.transaction.model;

import java.sql.Date;

import com.own.transaction.enums.TransactionSource;
import com.own.transaction.enums.TransactionStatus;
import com.own.transaction.enums.TransactionType;
import com.own.transaction.processor.PaymentProcessor;

public class ChildTransaction {

	private TransactionType transactionType;
	
	private String transactionRefNo;
	
	private String superTransactionRefNo;
	
	private double amount;
	
	private int customerID;
	
	private PaymentProcessor processor;

	private int payProcessorID;
	
	private Date created;
	
	private Date updated;
	
	private TransactionStatus status;
	
	private String merchantID;
	
	private TransactionSource  source;
	
	
	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionRefNo() {
		return transactionRefNo;
	}

	public void setTransactionRefNo(String transactionRefNo) {
		this.transactionRefNo = transactionRefNo;
	}

	public String getSuperTransactionRefNo() {
		return superTransactionRefNo;
	}

	public void setSuperTransactionRefNo(String superTransactionRefNo) {
		this.superTransactionRefNo = superTransactionRefNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getPayProcessorID() {
		return payProcessorID;
	}

	public void setPayProcessorID(int payProcessorID) {
		this.payProcessorID = payProcessorID;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public TransactionSource getSource() {
		return source;
	}

	public void setSource(TransactionSource source) {
		this.source = source;
	}

	public PaymentProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(PaymentProcessor processor) {
		this.processor = processor;
	}
	
}
