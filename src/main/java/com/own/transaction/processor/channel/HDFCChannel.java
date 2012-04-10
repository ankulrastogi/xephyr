package com.own.transaction.processor.channel;

import com.own.transaction.enums.ChannelStatus;
import com.own.transaction.enums.ChannelType;
import com.own.transaction.processor.PaymentProcessor;

public class HDFCChannel implements Channel {

	public void configureChannel() {
		// TODO Auto-generated method stub

	}

	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setStatus(ChannelStatus status) {
		// TODO Auto-generated method stub

	}

	public boolean testConnection() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deActivateChannel() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean connect() {
		// TODO Auto-generated method stub
		return false;
	}

	public void submitRequest(PaymentProcessor processor) {
		// TODO Auto-generated method stub

	}

	public void getRequestStatus(PaymentProcessor processor) {
		// TODO Auto-generated method stub

	}

	public ChannelType getChannelType() {
		// TODO Auto-generated method stub
		return null;
	}

}
