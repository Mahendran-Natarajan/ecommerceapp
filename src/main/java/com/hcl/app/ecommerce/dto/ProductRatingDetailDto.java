package com.hcl.app.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Product rating detail dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRatingDetailDto {
    private long ratingId;
    private double rating;
    private String storeName;
}
