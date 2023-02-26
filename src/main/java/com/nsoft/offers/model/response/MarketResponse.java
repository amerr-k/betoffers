package com.nsoft.offers.model.response;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MarketResponse {
	
	private String id;
	
	private String name;
	
	private Integer status;
	
	private List<String> eventIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getEventIds() {
		return eventIds;
	}

	public void setEventIds(List<String> eventIds) {
		this.eventIds = eventIds;
	}
	
}
