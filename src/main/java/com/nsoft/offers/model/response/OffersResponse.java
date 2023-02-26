package com.nsoft.offers.model.response;

import java.util.List;

public class OffersResponse {
	
	private List<EventResponse> events;
	
	private List<MarketResponse> markets;
	
	private List<OutcomeResponse> outcomes;

	public List<EventResponse> getEvents() {
		return events;
	}

	public void setEvents(List<EventResponse> events) {
		this.events = events;
	}

	public List<MarketResponse> getMarkets() {
		return markets;
	}

	public void setMarkets(List<MarketResponse> markets) {
		this.markets = markets;
	}

	public List<OutcomeResponse> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<OutcomeResponse> outcomes) {
		this.outcomes = outcomes;
	}

}
