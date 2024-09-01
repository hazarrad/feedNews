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
public class SummarizeTextRequest {

	@JsonProperty("content")
	private String content;
	@JsonProperty("voice_tone")
	private String voiceTone;
	@JsonProperty("max_length")
	private String maxLength;
	@JsonProperty("language")
	private String language;

}
