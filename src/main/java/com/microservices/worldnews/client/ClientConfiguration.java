package com.microservices.worldnews.client;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Headers;
import feign.Logger;
import feign.Logger.Level;
import feign.RequestInterceptor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "feign.client.config")
public class ClientConfiguration {

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.BASIC;
	}
//	
//	@Bean
//	String[] feignHeadersLevel(Headers header) {
//		return header.value();
//	}

	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			requestTemplate.header("x-apihub-key", "P1gL1SH2bfFN94rOqeLGAaWoU3IkrCdl4YS4v2hwUp4Q3pniyL");
			requestTemplate.header("x-apihub-host", "World-News-API.allthingsdev.co");
			requestTemplate.header("x-apihub-endpoint", "b3165457-cc74-4cbb-b056-ff6aa2932955");
		};
	}

//	@Bean
//	public RequestInterceptor requestInterceptor(Headers header) {
//
//		System.out.println("hey "+header.value());
//		return requestTemplate -> {
//			requestTemplate.header("x-apihub-key",header.value());
//			requestTemplate.header("x-apihub-host", "World-News-API.allthingsdev.co");
//			requestTemplate.header("x-apihub-endpoint", "b3165457-cc74-4cbb-b056-ff6aa2932955");
//		};
//	}

//	@Bean
//	public LoadBalancerFeignRequestTransformer transformer() {
//		return new LoadBalancerFeignRequestTransformer() {
//
//			@Override
//			public Request transformRequest(Request request, ServiceInstance instance) {
//				Map<String, Collection<String>> headers = new HashMap<>(request.headers());
//				headers.put("X-ServiceId", Collections.singletonList(instance.get()));
//				headers.put("X-InstanceId", Collections.singletonList(instance.getInstanceId()));
//				return Request.create(request.httpMethod(), request.url(), headers, request.body(), request.charset(),
//						request.requestTemplate());
//			}
//		};
//	}

}
