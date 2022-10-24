package com.api.ufood.model.restaurant;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latitude",
    "longitude"
})
public class Coordinates {
    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;
}
