package com.api.ufood.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@PropertySource("classpath:custom.properties")
@ConfigurationProperties("yelp")
public class YelpPropertiesConfig {
    // Customs properties
    private String hostUrl;
    private String apiKey;
}