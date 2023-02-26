package com.nsoft.offers.streams.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsoft.offers.model.market.Market;

@RestController
@RequestMapping("/markets")
public class MarketSenderController {

	@Autowired
	private MarketProducer marketProducer;

	@PutMapping()
	public void updateMarket(@RequestBody Market market) {
		marketProducer.produceMarketData(market);
	}
	
}
