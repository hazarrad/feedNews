package com.microservices.worldnews.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.worldnews.model.WorldNewsResponse;

import feign.HeaderMap;
import feign.Headers;

@FeignClient(value = "worldNews", name = "worldNews", url = "${feign.client.config.worldNews.url}", configuration = FeignClientsDecoder.class)
public interface WorldNewsClient {

	@GetMapping(path = "/search-news", headers = "${feign.client.config.worldNews.newHeaders}")
	@Headers("Content-Type: application/json")
	public WorldNewsResponse searchWorldNews(@RequestParam(name = "text", required = true) String text,
			@RequestParam(name = "source-countries", required = true) String sourcecountries,
			@RequestParam(name = "language", required = true) String language,
			@RequestParam(name = "min-sentiment", required = true) String minsentiment,
			@RequestParam(name = "max-sentiment", required = true) String maxsentiment,
			@RequestParam(name = "earliest-publish-date", required = true) String earliestpublishdate,
			@RequestParam(name = "latest-publish-date", required = true) String latestpublishdate,
			@RequestParam(name = "sort", required = true) String sort,
			@RequestParam(name = "sort-direction", required = true) String sortdirection,
			@RequestParam(name = "offset", required = true) String offset,
			@RequestParam(name = "number", required = true) String number);

}
