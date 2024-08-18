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
import com.microservices.worldnews.model.News;
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

		return syncStoreMultiThread();
	}

	private List<String> syncStoreMultiThread() {

		List<String> topNews = new ArrayList<>();
		List<String> requests = Arrays.asList("1", "20", "30", "5", "25", "34");

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
						topNews.addAll(syncStoreNewsV2(requests.get(j)));
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

	public List<String> syncStoreNewsV2(String requestOffset) {

		try {

			WorldNewsResponse worldNewsResponse = worldNewsClient.searchWorldNews("war", "US", "en", "-0.8", "0.99",
					"2022-04-22", "2024-04-24", "publish-time", "ASC", requestOffset, "10");
			return worldNewsResponse.getNews().stream().map(News::getTitle).collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Async method have a error: ", e.getMessage());
//			if (e.getCause() != null && !e.getCause().toString().equals(Constants.EMPTY_STRING)
//					&& !e.getCause().toString().contains(Constants.CODE_ERROR_404)) {
//				throw new BadRequestException(BadRequestException.Code.INVALIDBODY,
//						"FleetAccountAndOfferDetailApi response with a error: " + e.getMessage());
//
//			}
			throw new NullPointerException("hey sync call");
		}
	}

}
