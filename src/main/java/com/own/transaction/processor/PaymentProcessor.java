package com.own.transaction.processor;

import com.own.transaction.model.Transaction;
import com.own.transaction.processor.channel.ChannelSelector;
/**
 * Interface to handle the interaction between the system and the outside third party payment processors.
 * Outlines the basic functionality for payment processing.Any change in payment processor status should move up the chain and it
 * should be able to update the transaction status to which it belongs.
 * @author ankul
 *
 */
public interface PaymentProcessor {

	public void setChannelSelector(ChannelSelector selector);
	
	public void processTransaction(Transaction transaction);
	
	public void requestStatus(String processorID);
	
	public void requestCapture(String processorID);
	
	public void requestRefund(String processorID);
	
}
