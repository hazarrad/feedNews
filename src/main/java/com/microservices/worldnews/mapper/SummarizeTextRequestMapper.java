package com.microservices.worldnews.mapper;

import java.util.List;

import com.microservices.worldnews.model.SummarizeTextRequest;
import com.microservices.worldnews.utils.Constants;

import lombok.Builder;

@Builder
public class SummarizeTextRequestMapper {

	public static SummarizeTextRequest summarizeTextRequestMapper(String content) {

		return SummarizeTextRequest.builder().content(content).voiceTone(Constants.VOICE_TONE)
				.maxLength(Constants.MAX_LENGTH).language(Constants.SUM_LANGUAGE).build();
	}
	
//	private static List<String> adaptContent(
//			List<String> content) {
//		content.forEach(cba -> {
//		});
//		return content;
//	}


}
