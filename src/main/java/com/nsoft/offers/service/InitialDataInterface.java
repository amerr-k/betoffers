package com.nsoft.offers.service;

import java.util.List;

import com.nsoft.offers.model.event.Event;
import com.nsoft.offers.model.market.Market;

public interface InitialDataInterface {

	public List<Market> loadMarkets();
	
	public List<Event> loadEvents();
	
}
