package com.own.transaction.processor.channel;

import com.own.transaction.enums.ChannelStatus;
import com.own.transaction.enums.ChannelType;
import com.own.transaction.processor.PaymentProcessor;

/**
 * Determines an islocated channel connect to a particular bank for transactions
 * @author ankul
 *
 */

public interface Channel {
	
	
	/**
	 * Gets configuration information from the current context and loads the channel in the memory
	 */
	public void configureChannel();
	
	/**
	 * Gets the status of the current channet. Possible states are ACTIVE,INACTIVE
	 * @return
	 */
	public boolean getStatus();
	
	
	public void setStatus(ChannelStatus status);

	/**
	 * tests if the connection with the other end of the channel is still alive
	 * @return
	 */
	public boolean testConnection();
	
	/**
	 * Makes this channel non-usable for future transactions.
	 * @return
	 */
	public boolean deActivateChannel();
	
	/**
	 * Attempts to connect to the other end of the pipe.
	 * @return
	 */
	public boolean connect();
	
	/**
	 * Submits a particular Request for process with the gateway processor
	 * @param processor
	 */
	public void submitRequest(PaymentProcessor processor);
	
	/**
	 * Polls the payment processor for the status of a transaction
	 * @param processor
	 */
	public void getRequestStatus(PaymentProcessor processor);
	
	
	public ChannelType getChannelType();
	
}
