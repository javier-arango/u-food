package com.api.ufood.model.restaurant;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "is_closed",
    "start",
    "end",
    "is_overnight"
})
public class SpecialHour {
    @JsonProperty("date")
    private String date;

    @JsonProperty("is_closed")
    private String isClosed;

    @JsonProperty("start")
    private String start;

    @JsonProperty("end")
    private String end;

    @JsonProperty("is_overnight")
    private String isOvernight;
}
