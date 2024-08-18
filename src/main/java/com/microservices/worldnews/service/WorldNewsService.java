package com.microservices.worldnews.service;

import java.util.List;

public interface WorldNewsService {

	public List<String> searchWorldNews(String offset);
}
