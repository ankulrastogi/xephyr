package com.own.transaction;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.own.transaction.enums.TransactionStatus;
import com.own.transaction.exception.ValidateException;
import com.own.transaction.model.ServiceRequest;
import com.own.transaction.model.Transaction;
import com.own.transaction.model.ChildTransaction;
import com.own.transaction.utils.SuperTransactionUtils;

/**
 * Class that manages the lifecycle of a transaction
 * 
 * @author ankul
 *
 */
public class TransactionManagerImpl implements TransactionManager{

	

	/**
	 * Helps in creating a dummy transaction instance for the given payment
	 * @param request
	 */
	public void createTransactionFromRequest(ServiceRequest request) {
		
		//create a super transaction first
		
		Transaction sTran = new Transaction();
		sTran.setCreated(Calendar.getInstance().getTime());
		sTran.setMerhcantAccountID(request.getMerhcantID());
		sTran.setStatus(TransactionStatus.PENDING);
		sTran.setSubTransactionMap(new HashMap<String, ChildTransaction>());
		sTran.setReferenceNo(SuperTransactionUtils.generateSuperTransactionRefNo());
		
	}
	
	public boolean validateTransaction(ChildTransaction transaction) throws ValidateException
	{
		return false;
	}
	
	/**
	 * Tries to derive the new transaction status based on the given params like payment status, sub transaction status
	 * @param transaction
	 */
	public void updateTransactionStatus(Transaction transaction)
	{
		
	}

	
	public void updateSubTransactionStatus(ChildTransaction transaction)
	{
		
	}

	public Transaction createDummyTransactionFromRequest(ServiceRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ChildTransaction> getChildTransactions(ServiceRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateTransctionStatus(String transactionID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean cancelTransaction(String transactionID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean captureTransaction(String transactionID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean refundTransaction(String transactionID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteTransaction(String transactionID) {
		// TODO Auto-generated method stub
		return false;
	}

	public void saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	public Transaction getTransactionByID(String transactionID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Transaction> getTransactionForMerchant(String merchantID) {
		// TODO Auto-generated method stub
		return null;
	}
}
