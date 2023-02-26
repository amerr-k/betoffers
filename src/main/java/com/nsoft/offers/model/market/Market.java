package com.nsoft.offers.model.market;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Market {
	
	private String id;
	
	private String name;
	
	private Integer status;
	
	private List<MarketOutcome> outcomes;

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

	public List<MarketOutcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<MarketOutcome> outcomes) {
		this.outcomes = outcomes;
	}
	
}
