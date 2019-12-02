package com.hcl.app.ecommerce.service.impl;

import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.StoreDetail;
import com.hcl.app.ecommerce.repository.StoreDetailRepository;
import com.hcl.app.ecommerce.service.StoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Store detail service implementation
 * @author manatara
 * @since 27-11-2019
 * @version 1.0
 */
@Service
public class StoreDetailServiceImpl implements StoreDetailService {

    @Autowired
    private StoreDetailRepository storeDetailRepository;

    /**
     * Save store details
     * @param storeDetails holder for store details
     * @return  response code and response message
     */
    @Override
    public ApiResponse saveStoreDetails(StoreDetail storeDetails) {
        StoreDetail storeDetail = storeDetailRepository.save(storeDetails);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(201);
        apiResponse.setMessage("Saved Store ID " + storeDetail.getStoreId());
        return apiResponse;
    }

    /**
     *  Get store details by store id
     * @param storeId the store id
     * @return store detail
     */
    @Override
    public StoreDetail getStoreDetailsById(Long storeId) {
        Optional<StoreDetail> storeDetail = storeDetailRepository.findById(storeId);
        return storeDetail.orElse(null);
    }
}
