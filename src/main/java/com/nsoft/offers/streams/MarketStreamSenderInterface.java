package com.nsoft.offers.streams;

import com.nsoft.offers.model.market.Market;

public interface MarketStreamSenderInterface {
	
	public void produceMarketData(Market market);

}
