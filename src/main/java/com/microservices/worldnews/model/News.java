package com.microservices.worldnews.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "title", "text", "summary", "url", "image", "video", "publish_date", "author", "authors",
		"language", "source_country", "sentiment" })
public class News {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("text")
	private String text;
	@JsonProperty("summary")
	private String summary;
	@JsonProperty("url")
	private String url;
	@JsonProperty("image")
	private String image;
	@JsonProperty("video")
	private Object video;
	@JsonProperty("publish_date")
	private String publishDate;
	@JsonProperty("author")
	private String author;
	@JsonProperty("authors")
	private List<String> authors;
	@JsonProperty("language")
	private String language;
	@JsonProperty("source_country")
	private String sourceCountry;
	@JsonProperty("sentiment")
	private Double sentiment;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

}