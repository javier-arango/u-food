package com.api.ufood.controller;

import com.api.ufood.model.restaurant.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class RestaurantController {
    private final String API_HOST = "https://api.yelp.com";
    private final String YELP_API_KEY = "xS1VQjiaBhEHZyfbhmRuEqgbRxJbWX34BXjU3aqTVy13laeavHbmlEidjDmVq-SjoZ3gqIpY-8mgZJLhw88Y0anPpWcbgPWV_Q9hP2Vnql92HZcpBhs7Az7_1hZTY3Yx";
    Restaurant restaurant;

    @GetMapping("/restaurants")
    public String getAllRestaurants() {
        return "Hello World";
    }

    @GetMapping("/countries")
    public List<Objects> getRestaurant() {

        restaurant = new Restaurant();

        String url = "https://restcountries.eu/rest/v2/all";

        RestTemplate restTemplate = new RestTemplate();

        Objects[] countires = restTemplate.getForObject(url, Objects[].class);

        return Arrays.asList(countires);
    }

}
