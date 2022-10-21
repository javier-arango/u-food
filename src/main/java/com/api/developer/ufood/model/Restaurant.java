package com.api.developer.ufood.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * @param (start, end, day) Attributes
 */
record Hours(int start, int end, int day) {}

public class Restaurant {
    @Id
    @GeneratedValue
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

    // Default constructor
    public Restaurant() {}

    // Constructor
    public Restaurant(
            String name,
            String url,
            String phone,
            int reviewCount,
            List<String> categories,
            double rating,
            Location location,
            List<String> photos,
            String price,
            Hours hours
    ) {
        this.name = name;
        this.url = url;
        this.phone = phone;
        this.reviewCount = reviewCount;
        this.categories = categories;
        this.rating = rating;
        this.location = location;
        this.photos = photos;
        this.price = price;
        this.hours = hours;
    }

    /**
    * Getters & Setters for
    * {@link #getName()}
     * {@link #setName(String)}
    */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /**
     * Getters & Setters for
     * {@link #getUrl()}
     * {@link #setUrl(String)}
     */
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    /**
     * Getters & Setters for
     * {@link #getPhone()}
     * {@link #setPhone(String)}
     */
    public String getPhone() { return phone; }
    public void setPhone(String phone){ this.phone = phone; }

    /**
     * Getters & Setters for
     * {@link #getReviewCount()}
     * {@link #setReviewCount(int)}
     */
    public int getReviewCount() { return reviewCount; }
    public void setReviewCount(int reviewCount) { this.reviewCount = reviewCount; }

    /**
     * Getters & Setters for
     * {@link #getCategories()}
     * {@link #setCategories(List<String>)}
     */
    public List<String> getCategories() { return categories; }
    public void setCategories(List<String> categories) { this.categories = categories; }

    /**
     * Getters & Setters for
     * {@link #getRating()}
     * {@link #setRating(double)}
     */
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    /**
     * Getters & Setters for
     * {@link #getLocation()}
     * {@link #setLocation(Location)}
     */
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    /**
     * Getters & Setters for
     * {@link #getPhotos()}
     * {@link #setPhotos(List<String>)}
     */
    public List<String> getPhotos() { return photos; }
    public void setPhotos(List<String> photos) { this.photos = photos; }

    /**
     * Getters & Setters for
     * {@link #getPrice()}
     * {@link #setPrice(String)}
     */
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    /**
     * Getters & Setters for
     * {@link #getHours()}
     * {@link #setHours(Hours)}
     */
    public Hours getHours() { return hours; }
    public void setHours(Hours hours) { this.hours = hours; }
}
