package com.api.developer.ufood.model;


/**
 * @param (latitude, longitude) Attributes
 */
record Coordinates(double latitude, double longitude) {}

public class Location {
    // Attributes
    private String address;
    private String city;
    private int zipCode;
    private String country;
    private String state;
    private Coordinates coordinates;

    // Default constructor
    public Location() {}

    // Constructor
    public Location(
            String address,
            String city,
            int zipCode,
            String country,
            String state,
            Coordinates coordinates
    ) {
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.state = state;
        this.coordinates = coordinates;
    }

    /**
     * Getters & Setters for
     * {@link #getAddress()}
     * {@link #setAddress(String)}
     */
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    /**
     * Getters & Setters for
     * {@link #getCity()}
     * {@link #setCity(String)}
     */
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    /**
     * Getters & Setters for
     * {@link #getZipCode()}
     * {@link #setZipCode(int)}
     */
    public int getZipCode() { return zipCode; }
    public void setZipCode(int zipCode) { this.zipCode = zipCode; }

    /**
     * Getters & Setters for
     * {@link #getCountry()}
     * {@link #setCountry(String)}
     */
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    /**
     * Getters & Setters for
     * {@link #getState()}
     * {@link #setState(String)}
     */
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    /**
     * Getters & Setters for
     * {@link #getCoordinates()}
     * {@link #setCoordinates(Coordinates)}
     */
    public Coordinates getCoordinates() { return coordinates; }
    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }
}