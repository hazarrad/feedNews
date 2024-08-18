package com.microservices.worldnews.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "offset", "number", "available", "news" })
@Generated("jsonschema2pojo")
public class WorldNewsResponse {

	@JsonProperty("offset")
	private Integer offset;
	@JsonProperty("number")
	private Integer number;
	@JsonProperty("available")
	private Integer available;
	@JsonProperty("news")
	private List<News> news;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("offset")
	public Integer getOffset() {
		return offset;
	}

	@JsonProperty("offset")
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	@JsonProperty("number")
	public Integer getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(Integer number) {
		this.number = number;
	}

	@JsonProperty("available")
	public Integer getAvailable() {
		return available;
	}

	@JsonProperty("available")
	public void setAvailable(Integer available) {
		this.available = available;
	}

	@JsonProperty("news")
	public List<News> getNews() {
		return news;
	}

	@JsonProperty("news")
	public void setNews(List<News> news) {
		this.news = news;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}