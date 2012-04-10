package com.own.transaction.processor;

import com.own.transaction.model.Transaction;

public class PaymentProcessorFactory {

	/**
	 * Returns you appropriate payment processor needed for the transaction.Attaches the appropriate bank to the transaction
	 * As for now each transaction will be given same processor for each child transaction. If refund is requested then the 
	 * paymnent alloted to him will be same as the one held by the existing child transaction.
	 * @param type
	 * @return
	 */
	public PaymentProcessor getPaymentProcessorForTransaction(Transaction transaction)
	{
		return null;
	}
}
