package com.own.transaction.model;


import java.util.Date;
import java.util.Map;

import com.own.transaction.enums.TransactionStatus;


public class Transaction {
	
	private String merhcantAccountID;
	
	Map<String, ChildTransaction> subTransactionMap;
	
	private TransactionStatus status;
	
	private String referenceNo;
	
	private Date created;
	
	private Date updated;
	
	private boolean isFlagged;

	public String getMerhcantAccountID() {
		return merhcantAccountID;
	}

	public void setMerhcantAccountID(String merhcantAccountID) {
		this.merhcantAccountID = merhcantAccountID;
	}

	public Map<String, ChildTransaction> getSubTransactionMap() {
		return subTransactionMap;
	}

	public void setSubTransactionMap(Map<String, ChildTransaction> subTransactionMap) {
		this.subTransactionMap = subTransactionMap;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date date) {
		this.created = date;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	

}
