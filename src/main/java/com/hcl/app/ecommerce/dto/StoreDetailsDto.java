package com.hcl.app.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Store details dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDetailsDto {

    private long storeId;
    private String storeName;
    private String storeDesc;
    private String storeLocation;
    private Double storePrice;

}
