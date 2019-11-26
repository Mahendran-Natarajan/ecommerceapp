package com.hcl.app.ecommerce.service;

import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.entity.ProductRatingDetail;
import com.hcl.app.ecommerce.entity.StoreDetail;
import com.hcl.app.ecommerce.repository.StoreDetailRepository;
import com.hcl.app.ecommerce.service.impl.StoreDetailServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;

/**
 * The type Storet detail service test.
 */
@RunWith(MockitoJUnitRunner.class)
public class StoretDetailServiceTest {

    @InjectMocks
    private StoreDetailServiceImpl storeDetailService;

    @Mock
    private StoreDetailRepository storeDetailRepository;

    private StoreDetail storeDetail = new StoreDetail();

    @Before
    public void setup(){
        storeDetail.setStoreId(1);
        storeDetail.setStoreName("Amazon");
        storeDetail.setStoreDesc("Amazon Desc");
        Set<ProductRatingDetail> productRatingDetails = new HashSet<>();
        ProductRatingDetail productRatingDetail = new ProductRatingDetail();
        productRatingDetail.setRating(5);
        productRatingDetail.setRatingId(1);
        productRatingDetail.setProductDetail(new ProductDetail());
        productRatingDetails.add(productRatingDetail);
        storeDetail.setProductRatingDetail(productRatingDetails);

    }
    /**
     * Test get store negative.
     */
    @Test
    public void testGetStoreNegative() {
        Optional<StoreDetail> mockStoreDetail = Optional.of(storeDetail);
        StoreDetail storeDetailRes = storeDetailService.getStoreDetailsById(6L);
        Assert.assertNull(storeDetailRes);
    }

    /**
     * Test get product positive.
     */
    @Test
    public void testGetProductPositive() {
        Optional<StoreDetail> mockStoreDetail = Optional.of(storeDetail);
        Mockito.when(storeDetailRepository.findById(any())).thenReturn(mockStoreDetail);
        StoreDetail storeDetailRes = storeDetailService.getStoreDetailsById(1L);
        Assert.assertEquals(1, storeDetailRes.getStoreId());
    }


    /**
     * Test save store details.
     */
    @Test
    public void testSaveStoreDetails() {
        Mockito.when(storeDetailRepository.save(any())).thenReturn(storeDetail);
        ApiResponse apiResponse = storeDetailService.saveStoreDetails(storeDetail);
        Assert.assertNotNull(apiResponse);
        Assert.assertEquals(201, apiResponse.getStatusCode());
    }
}
