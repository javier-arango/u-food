package com.api.ufood.model.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import java.util.List;


@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "url",
    "display_phone",
    "categories",
    "location",
    "photos",
    "price",
    "hours",
    "transactions",
    "special_hours",
    "is_closed",
    "coordinates",
    "review_count",
    "rating",
    "review"
})
public class Restaurant {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    @JsonProperty("display_phone")
    private String displayPhone;

    @JsonProperty("categories")
    private List<Category> categories;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("photos")
    private List<String> photos;

    @JsonProperty("price")
    private String price;

    @JsonProperty("hours")
    private List<Hour> hours;

    @JsonProperty("transactions")
    private List<String> transactions;

    @Nullable
    @JsonProperty("special_hours")
    private List<SpecialHour> specialHours = null;

    @JsonProperty("is_closed")
    private boolean isClosed;

    @JsonProperty("coordinates")
    private Coordinates coordinates;

    @JsonProperty("review_count")
    private int reviewCount;

    @JsonProperty("rating")
    private double rating;

    @Nullable
    @JsonProperty("review")
    private Reviews review = null;
}
