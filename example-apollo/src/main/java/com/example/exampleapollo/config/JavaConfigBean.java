package com.example.exampleapollo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigBean {
  @Value("${timeout:20}")
  private int timeout;

  public int getTimeout() {
    return timeout;
  }
}