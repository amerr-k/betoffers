package com.nsoft.offers.model.response;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OutcomeResponse {
	
	private String id;
	
	private Integer status;

	private Double odds;
	
	private List<String> marketIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<String> getMarketIds() {
		return marketIds;
	}

	public void setMarketIds(List<String> marketIds) {
		this.marketIds = marketIds;
	}
	
}
