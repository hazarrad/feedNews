package com.microservices.worldnews.client;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservices.worldnews.client.configuration.FeignConfigProperties;
import com.microservices.worldnews.client.interceptor.feign.FeignNewHeaderInterceptor;

import feign.Logger;
import feign.RequestInterceptor;

@Configuration
@ConfigurationProperties(prefix = "feign.client.config")
@EnableConfigurationProperties({ FeignConfigProperties.class })
public class ClientConfiguration {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ClientConfiguration.class);

	private FeignConfigProperties feignConfigProperties;

	@Autowired
	public void setFeignConfigProperties(FeignConfigProperties feignConfigProperties) {
		this.feignConfigProperties = feignConfigProperties;
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.BASIC;
	}

	@Bean
	public RequestInterceptor feignNewHeaderSend() {
		log.info("Created bean FeignNewHeaderInterceptor");
		return (RequestInterceptor) new FeignNewHeaderInterceptor(this.feignConfigProperties);
	}
//	
//	@Bean
//	String[] feignHeadersLevel(Headers header) {
//		return header.value();
//	}
//
//	@Bean
//	public RequestInterceptor requestInterceptor() {
//		
//		return requestTemplate -> {
//			
//			requestTemplate.header("x-apihub-key", "P1gL1SH2bfFN94rOqeLGAaWoU3IkrCdl4YS4v2hwUp4Q3pniyL");
//			requestTemplate.header("x-apihub-host", "World-News-API.allthingsdev.co");
//			requestTemplate.header("x-apihub-endpoint", "b3165457-cc74-4cbb-b056-ff6aa2932955");
//		};
//	}

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
