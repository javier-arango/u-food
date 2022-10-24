package com.api.ufood.model.restaurant;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "reviews",
    "total",
    "possible_language"
})
public class Reviews {
    @JsonProperty("reviews")
    private List<Review> reviewList;

    @JsonProperty("total")
    private int total;
}
