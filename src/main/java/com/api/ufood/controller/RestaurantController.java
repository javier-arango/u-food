package com.api.ufood.controller;

import com.api.ufood.model.restaurant.Businesses;
import com.api.ufood.model.restaurant.Restaurant;
import com.api.ufood.model.restaurant.Reviews;
import com.api.ufood.service.RestaurantService;
import org.springframework.boot.web.client.RestTemplateBuilder;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/")
public class RestaurantController {

    @GetMapping("/restaurants/search")
    @ApiOperation(
            value= "Search for restaurants by location, limit, sortBy, and radius",
            notes = "Provide a location, limit, sortBy, and radius to look up restaurants from the YELP API",
            response = Businesses.class
    )
    public Businesses searchRestaurants(
            @RequestParam String location,
            @RequestParam int limit,
            @RequestParam(defaultValue = "distance") String sortBy,
            @RequestParam(defaultValue = "40000") int radius)
    {
        RestTemplateBuilder restTemplate = new RestTemplateBuilder();

        // Create service object
        RestaurantService restaurantService = new RestaurantService(restTemplate);

        // Make HTTP request to the Yelp API
        return restaurantService.getAllRestaurants(location, limit, sortBy, radius);
    }


    @GetMapping("/restaurant/{id}")
    @ApiOperation(
            value= "Find restaurant by id",
            notes = "Provide an id to look up specific restaurant from th YELP API",
            response = Restaurant.class
    )
    public Restaurant getRestaurant(@PathVariable String id) {
        RestTemplateBuilder restTemplate = new RestTemplateBuilder();

        // Create service object
        RestaurantService restaurantService = new RestaurantService(restTemplate);

        // Make HTTP request to the Yelp API
        return restaurantService.getRestaurant(id);
    }


    @GetMapping("/restaurant/{id}/reviews")
    @ApiOperation(
            value= "Find restaurant reviews by id",
            notes = "Provide an id to look up specific restaurant review from th YELP API",
            response = Reviews.class
    )
    public Reviews getReviews(@PathVariable String id) {
        RestTemplateBuilder restTemplate = new RestTemplateBuilder();

        // Create service object
        RestaurantService restaurantService = new RestaurantService(restTemplate);

        // Make HTTP request to the Yelp API
        return restaurantService.getReviews(id);
    }

}
