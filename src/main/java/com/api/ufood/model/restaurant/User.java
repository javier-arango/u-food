package com.api.ufood.model.restaurant;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "image_url",
    "name"
})
public class User {
    @JsonProperty("id")
    private String id;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("name")
    private String name;
}
