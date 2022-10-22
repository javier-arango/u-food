package com.api.ufood.controller;

import com.api.ufood.model.restaurant.Restaurant;
import com.api.ufood.service.RestaurantService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class RestaurantController {

    @GetMapping("/restaurants")
    public String getAllRestaurants() {
        return "Hello World";
    }

    @GetMapping("/countries")
    public Object getRestaurant() {
        // Make HTTP request to the Yelp API
        RestTemplateBuilder restTemplate = new RestTemplateBuilder();

        RestaurantService restaurantService = new RestaurantService(restTemplate);


        return restaurantService.getRestaurant();
    }

}
