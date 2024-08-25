package com.microservices.worldnews.client.configuration;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
@ConfigurationProperties(prefix = "feign.client")
public class FeignConfigProperties {
	private Map<String, Client> config;

	public void setConfig(Map<String, Client> config) {
		this.config = config;
	}

	public Map<String, Client> getConfig() {
		return this.config;
	}

	@Validated
	public static class Client {
		private String url;

		private boolean propagateAdditionalHeaders;

		private boolean propagateAuth;

		private Map<String, String> newHeaders;

		public void setUrl(String url) {
			this.url = url;
		}

		public void setPropagateAdditionalHeaders(boolean propagateAdditionalHeaders) {
			this.propagateAdditionalHeaders = propagateAdditionalHeaders;
		}

		public void setPropagateAuth(boolean propagateAuth) {
			this.propagateAuth = propagateAuth;
		}

		public void setNewHeaders(Map<String, String> newHeaders) {
			this.newHeaders = newHeaders;
		}

		public String getUrl() {
			return this.url;
		}

		public boolean isPropagateAdditionalHeaders() {
			return this.propagateAdditionalHeaders;
		}

		public boolean isPropagateAuth() {
			return this.propagateAuth;
		}

		public Map<String, String> getNewHeaders() {
			return this.newHeaders;
		}
	}
}
