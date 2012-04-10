package com.own.transaction;

import com.own.transaction.enums.PaymentProcessorType;
import com.own.transaction.enums.TransactionType;
import com.own.transaction.model.ChildTransaction;
import com.own.transaction.processor.PaymentProcessor;

public abstract class AbstractTransaction implements ITransaction {

	protected  TransactionType type;
	
	private PaymentProcessorType processorType;
	
	private PaymentProcessor processor;
	
	private ChildTransaction transaction;
	
}
