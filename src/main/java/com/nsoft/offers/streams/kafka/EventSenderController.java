package com.nsoft.offers.streams.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsoft.offers.model.event.Event;

@RestController
@RequestMapping("/events")
public class EventSenderController {

	@Autowired
	private EventProducer eventProducer;

	@PutMapping()
	public void updateMarket(@RequestBody Event event) {
		eventProducer.produceEventData(event);
	}
	
}
