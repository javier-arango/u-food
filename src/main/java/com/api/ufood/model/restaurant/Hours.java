package com.api.ufood.model.restaurant;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hours {
    private int start;
    private int end;
    private int day;
}
