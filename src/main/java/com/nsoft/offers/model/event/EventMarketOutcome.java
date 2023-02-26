package com.nsoft.offers.model.event;

import org.springframework.stereotype.Component;

@Component
public class EventMarketOutcome {
	
	private String id;
	
	private String outcomeId;
	
	private Integer status;

	private Double odds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOutcomeId() {
		return outcomeId;
	}

	public void setOutcomeId(String outcomeId) {
		this.outcomeId = outcomeId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getOdds() {
		return odds;
	}

	public void setOdds(Double odds) {
		this.odds = odds;
	}

}
