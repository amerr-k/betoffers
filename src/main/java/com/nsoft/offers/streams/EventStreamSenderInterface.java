package com.nsoft.offers.streams;

import com.nsoft.offers.model.event.Event;

public interface EventStreamSenderInterface {
	
	public void produceEventData(Event event);

}
