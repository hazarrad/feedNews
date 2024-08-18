package com.microservices.worldnews.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "feign.client.config")
public class FeignClientsDecoder implements ErrorDecoder {

	private static final Logger log = LogManager.getLogger(FeignClientsDecoder.class);

	private ErrorDecoder delegate = new ErrorDecoder.Default();

	@Override
	public Exception decode(String methodKey, Response response) {

		log.info("Response status on decoder {}", response.status());
		if (response.status() >= 500) {
			return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Error calling Service");
		} else if (response.status() >= 400 && response.status() < 500) {

			log.error("Response status on decoder {}", response.body());
			return new ResponseStatusException(HttpStatus.valueOf(response.status()), response.body().toString());

		}
		return delegate.decode(methodKey, response);

	}

}
