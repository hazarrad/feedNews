package com.microservices.worldnews.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {
	
	private Constants() {
	}

	// GENERAL FeedNews API
	public static final String TEXT = "war";
	public static final String SOURCE_COUNTRIES = "US";
	public static final String LANGUAGE = "en";
	public static final String MIN_SENTIMENT = "-0.8";
	public static final String MAX_SENTIMENT = "0.99";
	public static final String EARLIEST_PUBLISH_DATE = "2022-04-22";
	public static final String LATEST_PUBLISH_DATE = "2024-04-24";
	public static final String SORT = "publish-time";
	public static final String SORT_DIRECTION = "ASC";
	public static final List<String> OFFSET = Collections
			.unmodifiableList(Arrays.asList("1", "20", "30", "5", "25", "34"));
	public static final String NUMBER = "10";
	
	//Properties Summarize Text API
	public static final String VOICE_TONE = "news";
	public static final String MAX_LENGTH= "250";
	public static final String SUM_LANGUAGE = "English";

}
