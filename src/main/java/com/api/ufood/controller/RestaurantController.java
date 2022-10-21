package com.api.ufood.controller;

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



    @GetMapping("/restaurants")
    public String getAllRestaurants() {
        return "Hello World";
    }

    @GetMapping("/countries")
    public List<Objects> getRestaurant() {

        String url = "https://restcountries.eu/rest/v2/all";

        RestTemplate restTemplate = new RestTemplate();

        Objects[] countires = restTemplate.getForObject(url, Objects[].class);

        return Arrays.asList(countires);
    }

}
