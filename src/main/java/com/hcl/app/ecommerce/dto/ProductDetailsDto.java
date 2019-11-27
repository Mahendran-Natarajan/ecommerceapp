package com.hcl.app.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * The type Product details dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDto {


    private long productId;
    @NotBlank(message = "product name should not be blank")
    private String productName;
    private String productDesc;
}
