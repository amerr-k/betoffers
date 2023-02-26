package com.nsoft.offers.streams.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsoft.offers.error.OffersException;
import com.nsoft.offers.l18n.Message;
import com.nsoft.offers.model.event.Event;
import com.nsoft.offers.service.EventService;
import com.nsoft.offers.streams.EventStreamReceiverInterface;

@Component
public class EventConsumer implements EventStreamReceiverInterface {

	@Autowired
	EventService eventService;

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
    private Message messages;
	
	@Override
	@KafkaListener(topics = "events-topic")
	public void consumeEventData(String eventData) {
		Event event;
		try {
			event = objectMapper.readValue(eventData, Event.class);
			eventService.updateEvent(event);
		} catch (JsonProcessingException e) {
			throw new OffersException(messages.getMessage("error.internal-error"), e);
		}
	}

}