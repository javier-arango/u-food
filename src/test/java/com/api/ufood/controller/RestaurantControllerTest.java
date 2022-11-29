//package com.api.ufood.controller;
//
//import com.api.ufood.model.restaurant.Businesses;
//import com.api.ufood.model.restaurant.Restaurant;
//import com.api.ufood.service.RestaurantService;
//import com.api.ufood.testData.RestaurantTestData;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.mockito.Mockito.when;
//import static org.hamcrest.Matchers.*;
//
//@WebMvcTest
//public class RestaurantControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private RestaurantService restaurantService;
//
//    private RestaurantTestData restaurantTestData;
//
//    @BeforeEach
//    void init() {
//        restaurantTestData = new RestaurantTestData();
//    }
//
//
//    @Test
//    @DisplayName("testSearchRestaurants endpoint: '/restaurants/search'")
//    void shouldFetchAllRestaurant() throws Exception {
//        List<Restaurant> list = new ArrayList<>();
//        list.add(restaurantTestData.getRestaurant());
//
//        Businesses businesses = new Businesses();
//        businesses.setBusinesses(list);
//
//        when(restaurantService.searchRestaurants("miami, fl", 10, "distance", 4000)).thenReturn(businesses);
//
//        this.mockMvc.perform(get("/restaurants/search?limit=10&location=Miami%2C%20fl&radius=40000&sortBy=distance"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @DisplayName("testGetRestaurant endpoint: '/restaurant/{id}'")
//    void shouldFetchOneRestaurantByID() throws Exception  {
//        when(restaurantService.getRestaurant("O4MKx3JGik8JgsjFinvp8w")).thenReturn(restaurantTestData.getRestaurant());
//
//        this.mockMvc.perform(get("/restaurants/{id}", "O4MKx3JGik8JgsjFinvp8w"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(restaurantTestData.getRestaurant().getId())))
//                .andExpect(jsonPath("$.name", is(restaurantTestData.getRestaurant().getName())))
//                .andExpect(jsonPath("$.url", is(restaurantTestData.getRestaurant().getUrl())))
//                .andExpect(jsonPath("$.display_phone", is(restaurantTestData.getRestaurant().getDisplayPhone())))
//                .andExpect(jsonPath("$.photos", is(restaurantTestData.getRestaurant().getPhotos())))
//                .andExpect(jsonPath("$.price", is(restaurantTestData.getRestaurant().getPrice())))
//                .andExpect(jsonPath("$.transactions", is(restaurantTestData.getRestaurant().getTransactions())))
//                .andExpect(jsonPath("$.is_closed", is(restaurantTestData.getRestaurant().isClosed())))
//                .andExpect(jsonPath("$.review_count", is(restaurantTestData.getRestaurant().getReviewCount())))
//                .andExpect(jsonPath("$.rating", is(restaurantTestData.getRestaurant().getRating())));
//    }
//
//    @Test
//    @DisplayName("testGetReviews endpoint: '/restaurant/{id}/reviews'")
//    void shouldFetchReviewsByID() throws Exception  {
//        when(restaurantService.getReviews("O4MKx3JGik8JgsjFinvp8w")).thenReturn(restaurantTestData.getRestaurant().getReview());
//
//        this.mockMvc.perform(get("/restaurants/{id}/reviews", "O4MKx3JGik8JgsjFinvp8w"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.total", is(Objects.requireNonNull(restaurantTestData.getRestaurant().getReview()).getTotal())));
//    }
//
//    @Test
//    @DisplayName("testing for 'Not Found - 404' error | this should failed")
//    void shouldFailedWith404() throws Exception {
//        when(restaurantService.getRestaurant("12345")).thenReturn(restaurantTestData.getRestaurant());
//
//        this.mockMvc.perform(get("/restaurant/{id}/", "O4MKx3JGik8JgsjFinvp8w"))
//                .andExpect(status().is(404));
//    }
//
//    @Test
//    @DisplayName("testing for 'Not Found - 404' error | bad request")
//    void shouldFailedWith400() throws Exception {
//        when(restaurantService.getRestaurant("12345")).thenReturn(restaurantTestData.getRestaurant());
//
//        this.mockMvc.perform(get("/restaurant"))
//                .andExpect(status().is(404));
//    }
//}
