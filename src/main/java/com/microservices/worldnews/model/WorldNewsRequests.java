package com.microservices.worldnews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class WorldNewsRequests {

	@JsonProperty("text")
	private String text;
	@JsonProperty("source-countries")
	private String sourcecountries;
	@JsonProperty("language")
	private String language;
	@JsonProperty("min-sentiment")
	private String minsentiment;
	@JsonProperty("max-sentiment")
	private String maxsentiment;
	@JsonProperty("earliest-publish-date")
	private String earliestpublishdate;
	@JsonProperty("latest-publish-date")
	private String latestpublishdate;
	@JsonProperty("sort")
	private String sort;
	@JsonProperty("sort-direction")
	private String sortdirection;
	@JsonProperty("offset")
	private String offset;
	@JsonProperty("number")
	private String number;

}
