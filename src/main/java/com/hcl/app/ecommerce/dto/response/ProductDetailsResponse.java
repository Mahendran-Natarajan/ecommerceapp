package com.hcl.app.ecommerce.dto.response;

import com.hcl.app.ecommerce.dto.ProductDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Product details response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsResponse extends ApiResponse {
    private List<ProductDetailsDto> productDetailsDtos;
}
