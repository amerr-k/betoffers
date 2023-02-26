package com.nsoft.offers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nsoft.offers.model.market.Market;
import com.nsoft.offers.service.MarketService;

@RestController
@RequestMapping("/markets")
public class MarketController {

	@Autowired
	private MarketService marketService;

	@GetMapping()
	public ResponseEntity<List<Market>> getAllMarkets() {
		var markets = marketService.getAllMarkets();
		if (markets == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(markets);
		}
	}

}
