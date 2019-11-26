package com.hcl.app.ecommerce.web;

import com.hcl.app.ecommerce.dto.StoreDetailsDto;
import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.dto.response.StoreDetailsResponse;
import com.hcl.app.ecommerce.entity.StoreDetail;
import com.hcl.app.ecommerce.service.StoreDetailService;
import com.hcl.app.ecommerce.util.Constant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *  Store controller - all the stores related functions will be written here
 */
@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreDetailService storeDetailService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get store by store id
     *
     * @param storeId the store id
     * @return the all stores
     */
    @GetMapping
    public ResponseEntity<StoreDetailsResponse> getStoreById(@RequestParam String storeId) {
        StoreDetail storeDetail = this.storeDetailService.getStoreDetailsById(Long.parseLong(storeId));
        StoreDetailsResponse response = new StoreDetailsResponse();
        StoreDetailsDto storeDetailsDto = convertEntityToDto(storeDetail);
        List<StoreDetailsDto> storeDetailsDtos = new ArrayList<>();
        storeDetailsDtos.add(storeDetailsDto);
        response.setStoreDetailsDtos(storeDetailsDtos);
        response.setStatusCode(Constant.SUCCESS_CODE);
        response.setMessage(Constant.SUCCESS_MESSAGE);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Save store details response entity.
     *
     * @param storeDetailsDto the store details dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<ApiResponse> saveStoreDetails(@RequestBody StoreDetailsDto storeDetailsDto) {
        StoreDetail productDetail = convertToEntity(storeDetailsDto);
        ApiResponse apiResponse = this.storeDetailService.saveStoreDetails(productDetail);
        apiResponse.setMessage(Constant.SUCCESS_MESSAGE);
        apiResponse.setStatusCode(Constant.SUCCESS_CODE);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    private StoreDetail convertToEntity(StoreDetailsDto storeDetailsDto) {
        return modelMapper.map(storeDetailsDto, StoreDetail.class);
    }

    private StoreDetailsDto convertEntityToDto(StoreDetail storeDetail) {
        return modelMapper.map(storeDetail, StoreDetailsDto.class);
    }

}
