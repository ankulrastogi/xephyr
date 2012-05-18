package com.own.service.exception;


/**
 * General exception that will be thrown to the BL layer. The exception should concat all the 
 * exception codes that have been encountered during bubbling up
 * @author ankul
 *
 */
public class AppException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException(Throwable e) {
		super(e);
	}
	@Override
	public BaseException addErrorCode(String error, String message) {
		this.errorCodes.put(error, message);
		return this;
	}
}
