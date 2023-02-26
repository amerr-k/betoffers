package com.nsoft.offers.model.event;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Event {
	
	private String id;
	
	private String name;
	
	private Date startsAt; 
	
	private Integer status;
	
	private List<EventMarket> markets;

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

	public Date getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(Date startsAt) {
		this.startsAt = startsAt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<EventMarket> getMarkets() {
		return markets;
	}

	public void setMarkets(List<EventMarket> markets) {
		this.markets = markets;
	}
	
}
