package com.api.ufood.model.restaurant;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "businesses",
    "total",
    "region"
})
public class Businesses {
    @JsonProperty("businesses")
    private List<Restaurant> businesses;

    @JsonProperty("total")
    private int total;

    @JsonProperty("region")
    private Region region;
}
