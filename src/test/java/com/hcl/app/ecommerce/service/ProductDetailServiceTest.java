package com.hcl.app.ecommerce.service;

import com.hcl.app.ecommerce.dto.RatingPojo;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.repository.ProductDetailRepository;
import com.hcl.app.ecommerce.repository.ProductRatingDetailRepository;
import com.hcl.app.ecommerce.service.impl.ProductDetailServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

/**
 * The type Product detail service test.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductDetailServiceTest {

    @InjectMocks
    private ProductDetailServiceImpl productDetailService;

    @Mock
    private ProductDetailRepository productDetailRepository;

    @Mock
    private ProductRatingDetailRepository productRatingDetailRepository;

    /**
     * Test get product negative.
     */
    @Test
    public void testGetProductNegative() {
        Optional<ProductDetail> productDetails = Optional.of(new ProductDetail());
        Mockito.when(productDetailRepository.findById(any())).thenReturn(productDetails);
        Optional<ProductDetail> productDetailOptional = productDetailRepository.findById(Long.parseLong("1"));
        Assert.assertEquals(true, productDetailOptional.isPresent());
    }

    /**
     * Test get product positive.
     */
    @Test
    public void testGetProductPositive() {
        ProductDetail productDetail1 = new ProductDetail();
        productDetail1.setProductId(1);
        productDetail1.setProductName("MobileCase");
        productDetail1.setProductDesc("product desc");
        productDetail1.setStoreDetails(new HashSet<>());
        productDetail1.setProductRatingDetail(new HashSet<>());
        Optional<ProductDetail> productDetails = Optional.of(productDetail1);
        Mockito.when(productDetailRepository.findById(any())).thenReturn(productDetails);
        ProductDetail productDetail = productDetailService.getProduct("1");
        Optional<ProductDetail> productDetailOptional = productDetailRepository.findById(Long.parseLong("1"));
        Assert.assertEquals(true, productDetailOptional.isPresent());
    }

    /**
     * Test get store ratings.
     */
    @Test
    public void testGetStoreRatings() {
        List<RatingPojo> ratingPojos = new ArrayList<>();
        RatingPojo ratingPojo = new RatingPojo();
        ratingPojo.setRating(4.5);
        ratingPojo.setStoreName("Nokia");
        ratingPojos.add(ratingPojo);
        Mockito.when(productRatingDetailRepository.viewRatingsByStoreProduct(any())).thenReturn(ratingPojos);
        List<RatingPojo> pojos = productDetailService.getStoreRatings(Long.parseLong("1"));
        Assert.assertNotNull(pojos);
        Assert.assertEquals(1, pojos.size());
    }

    /**
     * Test get product by name.
     */
    @Test
    public void testGetProductByName() {
        List<ProductDetail> productDetails = new ArrayList<>();
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(1);
        productDetail.setProductName("Mobile");
        productDetails.add(productDetail);
        Mockito.when(productDetailRepository.findAllByProductNameContains(any())).thenReturn(productDetails);
        List<ProductDetail> productDetails1 = productDetailRepository.findAllByProductNameContains("Mobile");
        Assert.assertNotNull(productDetails1);
        Assert.assertEquals(1, productDetails1.size());
    }
}
