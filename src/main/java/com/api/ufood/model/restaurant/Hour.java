package com.api.ufood.model.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "open",
    "hours_type",
    "is_open_now"
})
public class Hour {
    @JsonProperty("open")
    private List<Open> open;

    @JsonProperty("hours_type")
    private String hoursType;

    @JsonProperty("is_open_now")
    private boolean isOpenNow;
}
