package com.own.transaction;

import java.util.List;

import com.own.transaction.model.ChildTransaction;
import com.own.transaction.model.ServiceRequest;
import com.own.transaction.model.Transaction;

/**
 * Single interface to manage the entire lifecycle of a transaction or a sub-transaction.
 * Helps in creating transaction,sub-transaction and updation of status.
 * Transaction status update should be bottom up i.e. Transaction status can only be
 * decided based on the status of its child transactions.
 * 
 * @author ankul
 *
 */
public interface TransactionManager {

	/**
	 * Creates a dummy transaction that can be validated and persisted in the DB. 
	 * It should also create a child transaction along with it and try to attach a payment processor to it as well.
	 * 
	 * @param request
	 * @return
	 */
	public Transaction createDummyTransactionFromRequest(ServiceRequest request);
	
	/**
	 * Gets the list of childTransactions associated with the given transaction
	 * @param request
	 * @return
	 */
	public List<ChildTransaction> getChildTransactions(ServiceRequest request);
	
	/**
	 * Update the transaction status based on the child transaction status which will internally be dependent on the payment processor status.
	 * First the child status needs to be updated then only the transaction status can be updated.
	 * @param transaction
	 * @return
	 */
	public boolean updateTransctionStatus(String transactionID);
	
	/**
	 * Cancels a given transaction. If it has sub transctions and none are in refund state then the subtransactions are also marked as CANCELLED.
	 * Refund transactions cannot/should not be cancelled.
	 * @param transactionID
	 * @return
	 */
	public boolean cancelTransaction(String transactionID);
	
	/**
	 * Tries to capture a transaction. Transaction can only be CAPTURED if it is AUTHORIZED. Else error should be thrown with proper error message.
	 * CAPTURING happens at the child transaction level. All the child transactions which are in AUTHORIZED statue are tried to be captured.
	 * Final transaction status can be CAPTURED or PARTIALLY CAPTURED based on the child status. 
	 * @param transactionID
	 * @return
	 */
	public boolean captureTransaction(String transactionID);
	
	/**
	 * Initiates a process of refund for the given transaction. If the amount is lesser than the transaction amount then a new child transaction 
	 * needs to be created to realize the refund. The transaction status in that case will be partial refund, from where it will move COMPLETED or 
	 * FAILED depending on the outcome of the transaction.  
	 * @param transactionID
	 * @return
	 */
	public boolean refundTransaction(String transactionID);
	
	/**
	 * Deletes a particular transaction. Not sure if the transction can be deleted. My take is it should be marked as abandoned. it should 
	 * also be cascading in nature, and the child transaction and payment processing should also be abandoned through appropriate channels.
	 * 
	 * @param transactionID
	 * @return
	 */
	public boolean deleteTransaction(String transactionID);
	
	/**
	 * Persists a particular transaction. It should also be cascading in nature, and the child transaction and payment processing should
	 *  also be persisted through appropriate channels.
	 * 
	 * @param transactionID
	 * @return
	 */
	public void saveTransaction(Transaction transaction);
	
	/**
	 * Retrieves details of an existing transaction
	 * @param transactionID
	 * @return
	 */
	public Transaction getTransactionByID(String transactionID);
	
	/**
	 * Get All the transactions for a particular merchant
	 * @param merchantID
	 * @return
	 */
	public List<Transaction> getTransactionForMerchant(String merchantID);
}
