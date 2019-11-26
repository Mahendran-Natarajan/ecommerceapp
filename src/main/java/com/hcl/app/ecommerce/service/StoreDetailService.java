package com.hcl.app.ecommerce.service;

import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.StoreDetail;

/**
 * The interface Store detail service.
 */
public interface StoreDetailService {

    /**
     * Save store details api response.
     *
     * @param storeDetail the store detail
     * @return the api response
     */
    public ApiResponse saveStoreDetails(StoreDetail storeDetail);

    /**
     * Gets store details by id.
     *
     * @param storeId the store id
     * @return the store details by id
     */
    public StoreDetail getStoreDetailsById(Long storeId);
}
