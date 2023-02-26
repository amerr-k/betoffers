package com.nsoft.offers.streams.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsoft.offers.error.OffersException;
import com.nsoft.offers.l18n.Message;
import com.nsoft.offers.model.event.Event;
import com.nsoft.offers.streams.EventStreamSenderInterface;

@Component
public class EventProducer implements EventStreamSenderInterface {

	private static final String EVENTS_TOPIC = "events-topic";
	
	@Autowired
	private KafkaTemplate<String, String> eventsTopicKafkaTemplate;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
    private Message messages;
	
	public void produceEventData(Event event) {
		String serialisedEvent;
		try {
			serialisedEvent = objectMapper.writeValueAsString(event);
			eventsTopicKafkaTemplate.send(EVENTS_TOPIC, event.getId(), serialisedEvent);
		} catch (JsonProcessingException e) {
			throw new OffersException(messages.getMessage("error.internal-error"), e);
		}
	}

}
