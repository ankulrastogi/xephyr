package com.own.transaction.processor.channel;

import java.util.List;

import com.own.transaction.enums.ChannelType;

public interface ChannelSelector {

	public Channel getChannel();

	public List<Channel> getAllChannels();

	public void loadChannels();
	
	public ChannelType getChannelType();
	
	public void setChannelType(ChannelType type);
	
	

}
