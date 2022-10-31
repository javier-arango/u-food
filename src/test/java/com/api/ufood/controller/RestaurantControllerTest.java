package com.api.ufood.controller;

import com.api.ufood.model.restaurant.Restaurant;

import com.api.ufood.service.RestaurantService;
import com.api.ufood.testData.RestaurantTestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.security.RunAs;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@ExtendWith(MockitoExtension.class)
public class RestaurantControllerTest {

    //private static MockMvc mockMvc;
    private static RestaurantTestData restaurantTestData;

//    @InjectMocks
//    private static RestaurantController restaurantController;


    @BeforeAll
    public static void setUp() throws Exception {
        //mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();

        restaurantTestData = new RestaurantTestData();
    }

    @Test
    @DisplayName("testSearchRestaurants endpoint: '/restaurant/{id}'")
    void testSearchRestaurants() throws Exception {
        Restaurant restaurantData = restaurantTestData.getRestaurant();

        RestaurantController response = new RestaurantController();

        assertEquals(restaurantData, response.getRestaurant("O4MKx3JGik8JgsjFinvp8w"));

//        mockMvc.perform(get("/api/v1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(view().name("index"))
//                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("testGetRestaurant endpoint: '/restaurant/{id}'")
    void testGetRestaurant() {

    }

    @Test
    @DisplayName("testGetReviews endpoint: '/restaurant/{id}/reviews'")
    void testGetReviews() {

    }
}
