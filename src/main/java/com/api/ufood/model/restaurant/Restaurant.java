package com.api.ufood.model.restaurant;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import java.util.List;


@Data
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String url;
    private String phone;
    private int reviewCount;
    private List<String> categories;
    private double rating;
    private Location location;
    private List<String> photos;
    private String price;
    private Hours hours;
}
