package com.microservices.worldnews.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.worldnews.model.JobStatusResponse;
import com.microservices.worldnews.model.SummarizeTextRequest;
import com.microservices.worldnews.model.SummarizeTextResponse;

import feign.Headers;

@FeignClient(value = "summarizeText", name = "summarizeText", url = "${feign.client.config.summarizeText.url}", configuration = FeignClientsDecoder.class)
public interface SummarizeTextClient {

	@PostMapping(path = "")
	@Headers("Content-Type: application/json")
	public SummarizeTextResponse summarizeText(@RequestBody SummarizeTextRequest summarizeTextRequest);

	@GetMapping(path = "job/status/{jobID}")
	@Headers("Content-Type: application/json")
	public JobStatusResponse getSummary(@PathVariable String jobID);

}