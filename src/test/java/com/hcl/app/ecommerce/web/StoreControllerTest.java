package com.hcl.app.ecommerce.web;

import com.hcl.app.ecommerce.dto.StoreDetailsDto;
import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.dto.response.StoreDetailsResponse;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.entity.ProductRatingDetail;
import com.hcl.app.ecommerce.entity.StoreDetail;
import com.hcl.app.ecommerce.entity.UserDetail;
import com.hcl.app.ecommerce.service.StoreDetailService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * The type Store controller test.
 */
@RunWith(MockitoJUnitRunner.class)
public class StoreControllerTest {

    @InjectMocks
    private StoreController storeController;


    @Mock
    private StoreDetailService storeDetailService;

    @Mock
    private ModelMapper modelMapper;

    StoreDetailsDto storeDetailsDto = new StoreDetailsDto();
    StoreDetail storeDetail = new StoreDetail();

    @Before
    public void setup() {

        storeDetailsDto.setStoreId(1);
        storeDetailsDto.setStoreName("Flipkart");
        storeDetailsDto.setStoreDesc("FlipKart Desc");
        storeDetailsDto.setStoreLocation("Bangalore");
        storeDetailsDto.setStorePrice(1500.00);


        storeDetail.setStoreId(1);
        storeDetail.setStoreName("Flipkart");
        storeDetail.setStoreDesc("FlipKart Desc");
        storeDetail.setStoreLocation("Bangalore");
        storeDetail.setProductDetails(new ProductDetail());
        storeDetail.setStorePrice(1500.00);
        ProductRatingDetail ratingDetail = new ProductRatingDetail();
        ratingDetail.setRating(1);
        ratingDetail.setRating(5);
        ratingDetail.setStoreDetail(storeDetail);
        ratingDetail.setUserDetails(new UserDetail());

        HashSet set = new HashSet();
        set.add(ratingDetail);
        storeDetail.setProductRatingDetail(set);
    }

    /**
     * Test get all stores.
     */
    @Test
    public void testGetAllStores() {

        when(this.storeDetailService.getStoreDetailsById(any())).thenReturn(storeDetail);
        ResponseEntity<StoreDetailsResponse> storeDetailsResponseResponseEntity = storeController.getStoreById("1");
        Assert.assertNotNull(storeDetailsResponseResponseEntity.getBody().getStoreDetailsDtos().size());
        Assert.assertNotNull(storeDetailsResponseResponseEntity.getBody().getMessage());
        Assert.assertNotNull(storeDetailsResponseResponseEntity);
        Assert.assertEquals(200, storeDetailsResponseResponseEntity.getStatusCode().value());
    }

    /**
     * Test save store.
     */
    @Test
    public void testSaveStore() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(200);
        apiResponse.setMessage("Success");
        StoreDetailsDto storeDetailsDto = Mockito.mock(StoreDetailsDto.class);
        when(this.storeDetailService.saveStoreDetails(any())).thenReturn(apiResponse);
        ResponseEntity<ApiResponse> apiResponseResult = storeController.saveStoreDetails(storeDetailsDto);
        Assert.assertNotNull(apiResponseResult);
        Assert.assertEquals(201, apiResponseResult.getStatusCode().value());
    }
}
