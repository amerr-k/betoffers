package com.nsoft.offers.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsoft.offers.error.OffersException;
import com.nsoft.offers.l18n.Message;
import com.nsoft.offers.model.event.Event;
import com.nsoft.offers.model.market.Market;

@Component
public class FileSystemDataLoader implements InitialDataInterface {

    @Value("${data.file.events.path}")
    private String eventFilePath;
	
    @Value("${data.file.markets.path}")
    private String marketFilePath;
    
	@Autowired
    private Message messages;

    @Override
    public List<Market> loadMarkets() {
        String marketList;
		try {
			marketList = new String(Files.readAllBytes(Paths.get(marketFilePath)), StandardCharsets.UTF_8);
	        return new ObjectMapper().readValue(marketList, new TypeReference<List<Market>>() {});
		} catch (IOException e) {
			throw new OffersException(messages.getMessage("error.internal-error"), e);
		}
    }
    
    @Override
    public ArrayList<Event> loadEvents() {
        String eventList;
		try {
			eventList = new String(Files.readAllBytes(Paths.get(eventFilePath)), StandardCharsets.UTF_8);
	        return new ObjectMapper().readValue(eventList, new TypeReference<ArrayList<Event>>() {});
		} catch (IOException e) {
			throw new OffersException(messages.getMessage("error.internal-error"), e);
		}
    }
}