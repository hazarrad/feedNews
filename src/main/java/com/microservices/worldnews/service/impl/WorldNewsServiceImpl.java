package com.microservices.worldnews.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.worldnews.client.WorldNewsClient;
import com.microservices.worldnews.mapper.SearchWorldNewsRequestMapper;
import com.microservices.worldnews.model.News;
import com.microservices.worldnews.model.WorldNewsRequests;
import com.microservices.worldnews.model.WorldNewsResponse;
import com.microservices.worldnews.service.WorldNewsService;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Builder
public class WorldNewsServiceImpl implements WorldNewsService {

	@Autowired
	private WorldNewsClient worldNewsClient;

	@Override
	public List<String> searchWorldNews(String offset) {
		List<String> requests = Arrays.asList("1", "20", "50", "40", "22", "14", "33");
		return syncStoreMultiThread(requests);
	}

	private List<String> syncStoreMultiThread(List<String> requests) {

		List<String> topNews = new ArrayList<>();

		int maxThreadsPerPool = 5;
		int poolSize = (requests.size() >= maxThreadsPerPool) ? (requests.size() / maxThreadsPerPool) : 1;
		ExecutorService executorService = Executors.newFixedThreadPool(poolSize);

		List<Future<String>> results = new ArrayList<>();

		for (int i = 0; i < requests.size(); i += maxThreadsPerPool) {
			int endIndex = Math.min(i + maxThreadsPerPool, requests.size());

			final int startIndex = i;
			final int endIndexFinal = endIndex;

			Callable<String> task = () -> {
				for (int j = startIndex; j < endIndexFinal; j++) {
					try {
						// syncStoreFleetAccount(request, chunks.get(j), messageId, fleetManagerId,
						// conversationId, date);
						topNews.addAll(syncGetNews(requests.get(j)));
					} catch (Exception e) {
						log.error("Error during syncStoreNewsV2");
					}
				}
				return Thread.currentThread().getName();
			};

			Future<String> result = executorService.submit(task);
			results.add(result);
		}

		for (Future<String> result : results) {
			try {
				String threadName = result.get();
				log.error("Thread name: " + threadName);
			} catch (InterruptedException | ExecutionException e) {
				log.error("Error with thread" + e.getLocalizedMessage());
				// e.printStackTrace();
			}
		}

		executorService.shutdown();

		return topNews;
	}

	public List<String> syncGetNews(String offset) {

		try {
			WorldNewsResponse worldNewsResponse = worldNewsClient
					.searchWorldNews(SearchWorldNewsRequestMapper.worldNewsRequestMapper(offset));
			return worldNewsResponse.getNews().stream().map(News::getTitle).collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Async method have a error: ", e.getMessage());
			throw new NullPointerException("hey sync call");
		}
	}

}
