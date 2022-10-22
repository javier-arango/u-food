package com.api.ufood.controller;

import com.api.ufood.model.restaurant.Restaurant;
import com.api.ufood.service.RestaurantService;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class RestaurantController {

    @GetMapping("/restaurants")
    public String getAllRestaurants() {
        return "Hello World";
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable String id) {
        RestTemplateBuilder restTemplate = new RestTemplateBuilder();

        // Make HTTP request to the Yelp API
        RestaurantService restaurantService = new RestaurantService(restTemplate);


        // Return the response
        return restaurantService.getRestaurant(id);
    }

}
