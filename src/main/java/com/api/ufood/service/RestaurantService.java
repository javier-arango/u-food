package com.api.ufood.service;

import com.api.ufood.model.restaurant.Businesses;
import com.api.ufood.model.restaurant.Restaurant;

import com.api.ufood.model.restaurant.Reviews;
import org.springframework.stereotype.Service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


@Service
public class RestaurantService {
    private final String HOST_URL;

    private final RestTemplate restTemplate;
    private final HttpEntity<String> entity;

    // Constructor
    public RestaurantService(RestTemplateBuilder restTemplateBuilder) {
        // Get rest template to do the http request
        this.restTemplate = restTemplateBuilder.build();

        // Set the HOST URL
        this.HOST_URL = "https://api.yelp.com/v3/businesses/";

        // Set header Authorization to the Yelp API Key
        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(System.getenv("YELP_API_KEY"));

        // Request body
        this.entity = new HttpEntity<>("body", headers);
    }


    /**
     * This method will return a List of Restaurant Object according to the default search
     * This method will be used to get the default restaurants for a user | Is use for the home page
     * {@link #getAllRestaurants(String, int, String, int)}
     * @return Restaurant
     *
     * @param limit | Number of business results to return. By default, it will return 10. Maximum is 50.
     * @param sortBy | The results be sorted by one of the these modes: best_match, rating, review_count or distance. The default is distance.
     * @param radius | A suggested search radius in meters. The max value is 40000 meters (about 25 miles). The default is 25 miles
     *
     */
    public Businesses getAllRestaurants(String location, int limit, String sortBy, int radius) {
        return restTemplate.exchange(
                HOST_URL +
                "search?location=" + location +
                "&term=restaurants" +
                "&limit=" + limit +
                "&sort_by=" + sortBy +
                "&radius=" + radius,
                HttpMethod.GET, entity, Businesses.class).getBody();
    }


    /**
     * This method will return a Restaurant Object according to their id
     * {@link #getRestaurant(String)}
     * @return Restaurant
     */
    public Restaurant getRestaurant(String id) {
        // Get restaurant details
        Restaurant restaurantDetails = restTemplate.exchange(HOST_URL + id, HttpMethod.GET, entity, Restaurant.class).getBody();

        // Get Restaurant reviews
        if (restaurantDetails != null) restaurantDetails.setReview(getReviews(restaurantDetails.getId()));

        return restaurantDetails;
    }


    /**
     * This method will return a Reviews Object according to the restaurant id
     * {@link #getReviews(String)}
     * @return Restaurant
     */
    public Reviews getReviews(String id) { return restTemplate.exchange(HOST_URL + id + "/reviews", HttpMethod.GET, entity, Reviews.class).getBody(); }
}
