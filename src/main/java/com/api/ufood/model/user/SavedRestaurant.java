package com.api.ufood.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "savedRestaurants")

public class SavedRestaurant {
    @Id
    @Column(name = "saved_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rest_id")
    private String restaurant_id;
}
