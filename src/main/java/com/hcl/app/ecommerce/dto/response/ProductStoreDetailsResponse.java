package com.hcl.app.ecommerce.dto.response;

import com.hcl.app.ecommerce.dto.ProductStoreDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Product store details response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductStoreDetailsResponse extends ApiResponse {

    private List<ProductStoreDetailsDto> productStoreDetailsDtos;

}
