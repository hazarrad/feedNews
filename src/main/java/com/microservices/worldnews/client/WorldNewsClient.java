package com.microservices.worldnews.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.worldnews.model.WorldNewsResponse;

import feign.Headers;

@FeignClient(value = "worldNews", name = "worldNews", url = "${feign.client.config.worldNews.url}", configuration = FeignClientsDecoder.class)
public interface WorldNewsClient {

	@GetMapping(path = "/search-news")
	@Headers("Content-Type: application/json")
	public WorldNewsResponse searchWorldNews(@RequestParam Map<String, Object> parameters);

}
