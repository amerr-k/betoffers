package com.nsoft.offers.service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nsoft.offers.model.event.Event;
import com.nsoft.offers.model.event.EventData;
import com.nsoft.offers.model.event.EventMarket;
import com.nsoft.offers.model.market.Market;
import com.nsoft.offers.model.market.MarketData;
import com.nsoft.offers.model.response.EventResponse;
import com.nsoft.offers.model.response.MarketResponse;
import com.nsoft.offers.model.response.OffersResponse;

@Service
public class EventService {

	@Autowired
	public EventData eventData;
	
	@Autowired
	public MarketData marketData;
	
	@Autowired
	public ModelMapper modelMapper;

	public OffersResponse getAllEvents() {
		var events = eventData.getEvents();
		var markets = marketData.getMarkets();
		
		var offerResponse = new OffersResponse();
		setEvents(offerResponse, events);
		setMarkets(offerResponse, events, markets);
		setOutcomes();

		return offerResponse;
		
	}
	
	private void setEvents(OffersResponse offerResponse, List<Event> events) {
		List<EventResponse> eventResponseList = modelMapper.map(events, new TypeToken<List<EventResponse>>(){}.getType());
		offerResponse.setEvents(eventResponseList);
	}
	
	private void setMarkets(OffersResponse offersResponse, List<Event> events, List<Market> markets) {
		var marketResponseList = new ArrayList<MarketResponse>();
		for (var event : events) {
			var eventMarkets = event.getMarkets();
			for (var eventMarket : eventMarkets) {		
				var marketResponseOpt = marketResponseList.stream()
					.filter(x -> x.getId().equals(eventMarket.getMarketId()))
					.findFirst();
				
				if(marketResponseOpt.isPresent()) {
					var marketResponse = marketResponseOpt.get();
					var marketEventIds = marketResponse.getEventIds();
					if(marketEventIds == null) {
						marketEventIds = new ArrayList<String>();
					}
					marketEventIds.add(event.getId());
					marketResponse.setEventIds(marketEventIds);
				} else {
					var marketOpt = markets.stream()
							.filter(x -> x.getId().equals(eventMarket.getMarketId()))
							.findFirst();
					
					if(marketOpt.isPresent()) {
						var market = marketOpt.get();
						var newMarketResponse = modelMapper.map(market, MarketResponse.class);
						marketResponseList.add(newMarketResponse);
					}
				}
			}
		}
		offersResponse.setMarkets(marketResponseList);
	}

	private void setOutcomes() {
		
	}
	
	public void updateEvent(Event event) {
		var eventList = eventData.getEvents();
		var eventExists = false;
		var existingEventIndex = -1;
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getId().equals(event.getId())) {
				eventExists = true;
				existingEventIndex = i;
				break;
			}
		}

		if (eventExists) {	
			var existingEventMarkets = eventList.get(existingEventIndex).getMarkets();
			var sentMarkets = event.getMarkets();
			updateEventMarkets(existingEventMarkets, sentMarkets);
		} else {
			eventList.add(event);
		}

	}
	
	public void updateEventMarkets(List<EventMarket> existingEventMarkets, List<EventMarket> newMarkets) {
		for (int i = 0; i < newMarkets.size(); i++) {
			var marketExists = false;
			var existingMarketIndex = -1;
			var newMarket = newMarkets.get(i);
			for (int j = 0; j < existingEventMarkets.size(); j++) {
				if (existingEventMarkets.get(j).getId().equals(newMarket.getId())) {
					marketExists = true;
					existingMarketIndex = i;
					break;
				}
			}
			
			if (marketExists) {
				existingEventMarkets.remove(existingMarketIndex);
				existingEventMarkets.add(existingMarketIndex, newMarket);
			} else {
				existingEventMarkets.add(newMarket);
			}
		}
	}

}
