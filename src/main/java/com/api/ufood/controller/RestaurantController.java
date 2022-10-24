package com.api.ufood.controller;

import com.api.ufood.model.restaurant.Businesses;
import com.api.ufood.model.restaurant.Restaurant;
import com.api.ufood.model.restaurant.Reviews;
import com.api.ufood.service.RestaurantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class RestaurantController {

    @GetMapping("/restaurants")
    @ApiOperation(
            value= "Find all the restaurants using a default search",
            notes = "This API request use default params underneath to make calls to YELP API:\n \nlocation=University of Florida \nlimit=10 \nradius=4000",
            response = Businesses.class
    )
    public Businesses getAllRestaurants() {
        RestTemplateBuilder restTemplate = new RestTemplateBuilder();

        // Create service object
        RestaurantService restaurantService = new RestaurantService(restTemplate);

        // Make HTTP request to the Yelp API
        return restaurantService.getAllRestaurants("University of Florida", 10, "distance", 40000);
    }

    @GetMapping("/restaurants/search/{location}&{limit}&{sortBy}&{radius}")
    @ApiOperation(
            value= "Search for restaurants by location, limit, sortBy, and radius",
            notes = "Provide a location, limit, sortBy, and radius to look up restaurants from the YELP API",
            response = Businesses.class
    )
    public Businesses searchRestaurants(@PathVariable String location, @PathVariable int limit, @PathVariable String sortBy, @PathVariable int radius) {
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
