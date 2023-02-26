package com.nsoft.offers.model.event;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EventMarket {
	
	private String id;
	
	private String marketId;
	
	private Integer status;
	
	private List<EventMarketOutcome> outcomes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<EventMarketOutcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<EventMarketOutcome> outcomes) {
		this.outcomes = outcomes;
	}
	
}
