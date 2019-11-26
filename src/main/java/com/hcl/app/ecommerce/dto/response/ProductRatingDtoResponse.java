package com.hcl.app.ecommerce.dto.response;

import com.hcl.app.ecommerce.dto.ProductDetailsDto;
import com.hcl.app.ecommerce.dto.ProductRatingDetailDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Product rating dto response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRatingDtoResponse extends ApiResponse {
    private List<ProductDetailsDto> productDetailsDtos;
    private List<ProductRatingDetailDto> productRatingDetailDtos;

}
