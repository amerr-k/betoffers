package com.nsoft.offers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsoft.offers.model.market.Market;
import com.nsoft.offers.model.market.MarketData;

@Service
public class MarketService {

	@Autowired
	public MarketData marketData;

	public List<Market> getAllMarkets() {
		return marketData.getMarkets();
	}

	public void updateMarket(Market market) {
		var marketList = marketData.getMarkets();
		var marketExists = false;
		var existingModelIndex = -1;
		for (int i = 0; i < marketList.size(); i++) {
			if (marketList.get(i).getId().equals(market.getId())) {
				marketExists = true;
				existingModelIndex = i;
				break;
			}
		}

		if (marketExists) {
			marketList.remove(existingModelIndex);
			marketList.add(existingModelIndex, market);
		} else {
			marketList.add(market);
		}

	}

}
