package com.nsoft.offers.model.market;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MarketData {
	
	private List<Market> markets;
    
	public List<Market> getMarkets() {
		return markets;
	}

	public void setMarkets(List<Market> markets) {
		this.markets = markets;
	}
	
}
