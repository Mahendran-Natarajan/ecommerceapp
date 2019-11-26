package com.hcl.app.ecommerce.dto.response;

import com.hcl.app.ecommerce.dto.StoreDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Store details response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreDetailsResponse extends ApiResponse {

    private List<StoreDetailsDto> storeDetailsDtos;

}
