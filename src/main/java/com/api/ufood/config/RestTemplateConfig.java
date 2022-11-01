package com.api.ufood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplateConfig {
    @Autowired
    private YelpPropertiesConfig yelpPropertiesConfig;


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Bean
    public HttpEntity<String> entity() {
        // Set header Authorization to the Yelp API Key
        HttpHeaders headers = new HttpHeaders();

        // Set the Authentication to the Yelp API
        headers.setBearerAuth(yelpPropertiesConfig.getApiKey());

        // Return entity
        return new HttpEntity<>("body", headers);
    }

}
