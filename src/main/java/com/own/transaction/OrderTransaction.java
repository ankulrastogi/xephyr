package com.own.transaction;

import com.own.transaction.enums.TransactionType;

public class OrderTransaction extends AbstractTransaction{
	
	public OrderTransaction() {
		super();
		type = TransactionType.ORDER;
	}
	
}
