package com.hcl.app.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Product details dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDto {


    private long productId;
    private String productName;
    private String productDesc;
}
