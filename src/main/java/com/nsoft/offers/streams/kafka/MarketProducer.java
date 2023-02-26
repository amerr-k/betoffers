package com.nsoft.offers.streams.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsoft.offers.error.OffersException;
import com.nsoft.offers.l18n.Message;
import com.nsoft.offers.model.market.Market;
import com.nsoft.offers.streams.MarketStreamSenderInterface;

@Component
public class MarketProducer implements MarketStreamSenderInterface {
	
	private static final String MARKETS_TOPIC = "markets-topic";
	
	@Autowired
    private KafkaTemplate<String, String> marketsTopicKafkaTemplate;

	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
    private Message messages;
		
	@Override
	public void produceMarketData(Market market) {
		String serialisedMarket;
		try {
			serialisedMarket = objectMapper.writeValueAsString(market);
			marketsTopicKafkaTemplate.send(MARKETS_TOPIC, serialisedMarket);
		} catch (JsonProcessingException e) {
			throw new OffersException(messages.getMessage("error.internal-error"), e);
		}

	}
}
