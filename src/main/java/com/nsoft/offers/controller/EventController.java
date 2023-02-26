package com.nsoft.offers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nsoft.offers.model.response.OffersResponse;
import com.nsoft.offers.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping()
	public ResponseEntity<OffersResponse> getAllEvents() {
		var events = eventService.getAllEvents();
		if (events == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(events);
		}
	}

}
