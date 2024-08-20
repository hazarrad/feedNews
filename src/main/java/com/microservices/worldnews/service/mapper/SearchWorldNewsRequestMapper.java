package com.microservices.worldnews.service.mapper;

import java.util.Map;

import com.microservices.worldnews.model.WorldNewsRequests;
import com.microservices.worldnews.service.utils.Constants;
import com.microservices.worldnews.service.utils.Utils;

import lombok.Builder;

@Builder
public class SearchWorldNewsRequestMapper {

	public static Map<String, Object> worldNewsRequestMapper(String offset) {

		return Utils.convertUsingReflection(
				WorldNewsRequests.builder().text(Constants.TEXT).sourcecountries(Constants.SOURCE_COUNTRIES)
						.language(Constants.LANGUAGE).minsentiment(Constants.MIN_SENTIMENT)
						.maxsentiment(Constants.MAX_SENTIMENT).earliestpublishdate(Constants.EARLIEST_PUBLISH_DATE)
						.latestpublishdate(Constants.LATEST_PUBLISH_DATE).sort(Constants.SORT)
						.sortdirection(Constants.SORT_DIRECTION).offset(offset).number(Constants.NUMBER).build());
	}

}
