package com.api.ufood.model.restaurant;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address1",
    "address2",
    "address3",
    "city",
    "zip_code",
    "country",
    "state"
})
public class Location {
    @JsonProperty("address1")
    private String address1;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("address3")
    private String address3;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip_code")
    private String zipCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("state")
    private String state;
}
