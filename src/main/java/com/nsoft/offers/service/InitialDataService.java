package com.nsoft.offers.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.nsoft.offers.model.event.Event;
import com.nsoft.offers.model.event.EventData;
import com.nsoft.offers.model.market.MarketData;

@Component
public class InitialDataService implements ApplicationRunner {

	@Autowired
	public MarketData marketData;
	
	@Autowired
	public EventData eventData;

	@Autowired
	public FileSystemDataLoader fileSystemDataLoader;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		marketData.setMarkets(fileSystemDataLoader.loadMarkets());
		setEvents(fileSystemDataLoader.loadEvents());
	}
	 
	private void setEvents(ArrayList<Event> eventList) {
		invalidateNonExistingOutcomes(eventList);
		eventData.setEvents(eventList);
	}
	
	private void invalidateNonExistingOutcomes(ArrayList<Event> eventList) {
		for (var event : eventList) {
			for (var eventMarket : event.getMarkets()) {
				for (var eventMarketOutcome : eventMarket.getOutcomes()) {
					var outcomeExists = false;
					for (var market : marketData.getMarkets()) {
						outcomeExists = market.getOutcomes().stream()
								.filter(y -> y.getStatus() != 0)
								.anyMatch(x -> x.getId().equals(eventMarketOutcome.getOutcomeId()));
						if(outcomeExists) {
							break;
						}
					}
					if(!outcomeExists) {				
						eventMarketOutcome.setStatus(0);
					}
				}
			}
		}
	}

}
