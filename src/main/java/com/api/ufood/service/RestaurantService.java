package com.api.ufood.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import com.api.ufood.model.restaurant.Restaurant;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


@Service
public class RestaurantService {
    private final String HOST_URL;
    private final String API_KEY;

    private final RestTemplate restTemplate;
    private final HttpEntity<String> entity;

    // Constructor
    public RestaurantService(RestTemplateBuilder restTemplateBuilder) {
        // Get rest template to do the http request
        this.restTemplate = restTemplateBuilder.build();

        // Load Environmental variables from .env
        Dotenv dotenv = Dotenv.load();
        this.HOST_URL = dotenv.get("YELP_HOST_URL");;
        this.API_KEY = dotenv.get("YELP_API_KEY");

        // Set header Authorization to the Yelp API Key
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(API_KEY);

        // Request body
        this.entity = new HttpEntity<>("body", headers);
    }

    /**
     * This method will return a Restaurant Object according to their id
     * {@link #getRestaurant(String)}
     * @return Restaurant
     */
    public Restaurant getRestaurant(String id) { return restTemplate.exchange(HOST_URL + id, HttpMethod.GET, entity, Restaurant.class).getBody(); }
}
