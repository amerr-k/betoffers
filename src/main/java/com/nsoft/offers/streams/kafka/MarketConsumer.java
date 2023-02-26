package com.nsoft.offers.streams.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsoft.offers.error.OffersException;
import com.nsoft.offers.l18n.Message;
import com.nsoft.offers.model.market.Market;
import com.nsoft.offers.service.MarketService;
import com.nsoft.offers.streams.MarketStreamReceiverInterface;

@Component
public class MarketConsumer implements MarketStreamReceiverInterface {
	
	@Autowired
	MarketService marketService;

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
    private Message messages;

	@Override
	@KafkaListener(topics = "markets-topic")
	public void consumeMarketData(String marketData) {
		Market market;
		try {
			market = objectMapper.readValue(marketData, Market.class);
			marketService.updateMarket(market);
		} catch (JsonProcessingException e) {
			throw new OffersException(messages.getMessage("error.internal-error"), e);
		}
	}

}