package com.microservices.worldnews.client.interceptor.feign;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microservices.worldnews.client.configuration.FeignConfigProperties;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignNewHeaderInterceptor implements RequestInterceptor {
  private static final Logger log = LoggerFactory.getLogger(FeignNewHeaderInterceptor.class);
  
  private FeignConfigProperties feignConfigProperties;
  
  public FeignNewHeaderInterceptor(FeignConfigProperties feignConfigProperties) {
    this.feignConfigProperties = feignConfigProperties;
  }
  
  public void apply(RequestTemplate template) {
    if (this.feignConfigProperties.getConfig() != null && this.feignConfigProperties
      .getConfig().get(template.feignTarget().name()) != null && ((FeignConfigProperties.Client)this.feignConfigProperties
      .getConfig().get(template.feignTarget().name())).getNewHeaders() != null && 
      !((FeignConfigProperties.Client)this.feignConfigProperties.getConfig().get(template.feignTarget().name())).getNewHeaders().isEmpty()) {
      Objects.requireNonNull(template);
      ((FeignConfigProperties.Client)this.feignConfigProperties.getConfig().get(template.feignTarget().name())).getNewHeaders().forEach((x$0, xva$1) -> template.header(x$0, new String[] { xva$1 }));
      log.debug("Feign call to {} with New Header propagation", template.feignTarget().url());
    } 
  }
}

