package com.hcl.app.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Rating pojo.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RatingPojo {
    private double rating;
    private String storeName;
}
