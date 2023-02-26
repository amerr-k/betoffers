package com.nsoft.offers.model.event;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EventData {
	
	private List<Event> events;

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
