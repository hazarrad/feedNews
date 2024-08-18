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
@JsonPropertyOrder({ "id", "title", "text", "summary", "url", "image", "video", "publish_date", "author", "authors",
		"language", "source_country", "sentiment" })
@Generated("jsonschema2pojo")
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

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("summary")
	public String getSummary() {
		return summary;
	}

	@JsonProperty("summary")
	public void setSummary(String summary) {
		this.summary = summary;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("image")
	public String getImage() {
		return image;
	}

	@JsonProperty("image")
	public void setImage(String image) {
		this.image = image;
	}

	@JsonProperty("video")
	public Object getVideo() {
		return video;
	}

	@JsonProperty("video")
	public void setVideo(Object video) {
		this.video = video;
	}

	@JsonProperty("publish_date")
	public String getPublishDate() {
		return publishDate;
	}

	@JsonProperty("publish_date")
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	@JsonProperty("author")
	public void setAuthor(String author) {
		this.author = author;
	}

	@JsonProperty("authors")
	public List<String> getAuthors() {
		return authors;
	}

	@JsonProperty("authors")
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("source_country")
	public String getSourceCountry() {
		return sourceCountry;
	}

	@JsonProperty("source_country")
	public void setSourceCountry(String sourceCountry) {
		this.sourceCountry = sourceCountry;
	}

	@JsonProperty("sentiment")
	public Double getSentiment() {
		return sentiment;
	}

	@JsonProperty("sentiment")
	public void setSentiment(Double sentiment) {
		this.sentiment = sentiment;
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