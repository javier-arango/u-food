package com.api.ufood.model.restaurant;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Location {
    // Attributes
    private String address;
    private String city;
    private int zipCode;
    private String country;
    private String state;
    private Coordinates coordinates;
}