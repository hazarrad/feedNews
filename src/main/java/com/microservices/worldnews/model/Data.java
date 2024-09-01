package com.microservices.worldnews.model;

import javax.annotation.Generated;

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
@JsonPropertyOrder({ "type", "id", "attributes" })
@Generated("jsonschema2pojo")
public class Data {

	@JsonProperty("type")
	private String type;
	@JsonProperty("id")
	private String id;
	@JsonProperty("attributes")
	private Attributes attributes;

}