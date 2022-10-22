package com.api.ufood.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.api.ufood.model.restaurant.Restaurant;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestaurantService {
    // Attributes
    private final RestTemplate restTemplate;
    private final String URL = "";
    private final String API_KEY = "";

    // Constructor
    public RestaurantService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

        // Message in case there is an error getting the response
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        this.restTemplate.setMessageConverters(messageConverters);
    }

    public Object getRestaurant() {
        // Set header Authorization to the Yelp API Key
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(URL, HttpMethod.GET, entity, Object.class).getBody();
    }
}
