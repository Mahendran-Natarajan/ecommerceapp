package com.hcl.app.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * The type Product store details dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductStoreDetailsDto {

    private long productStoreId;
    @NotBlank(message = "product price should not be blank")
    private Double productPrice;
}
