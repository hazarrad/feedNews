package com.microservices.worldnews.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.worldnews.model.WorldNewsResponse;
import com.microservices.worldnews.service.WorldNewsService;

@RestController
public class worldNewsController {

	@Autowired
	private WorldNewsService worldNewsService;

	@GetMapping(path = "/feedNews")
	public ResponseEntity<List<String>> getFeedNews() {

		List<String> response = worldNewsService.searchWorldNews("1");
		return new ResponseEntity<List<String>>(response, HttpStatus.OK);

	}

}
