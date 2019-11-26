package com.hcl.app.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Product store details dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductStoreDetailsDto {

    private long productStoreId;
    private Double productPrice;
}
