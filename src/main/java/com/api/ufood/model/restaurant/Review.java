package com.api.ufood.model.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "rating",
    "user",
    "text",
    "time_created"
})
public class Review {
    @JsonProperty("id")
    private String id;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("user")
    private User user;

    @JsonProperty("text")
    private String text;

    @JsonProperty("time_created")
    private String timeCreated;
}
