package com.hcl.app.ecommerce.web;

import com.hcl.app.ecommerce.dto.ProductDetailsDto;
import com.hcl.app.ecommerce.dto.ProductRatingDetailDto;
import com.hcl.app.ecommerce.dto.RatingPojo;
import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.dto.response.ProductDetailsResponse;
import com.hcl.app.ecommerce.dto.response.ProductRatingDtoResponse;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.entity.ProductRatingDetail;
import com.hcl.app.ecommerce.exception.ProductNotFoundException;
import com.hcl.app.ecommerce.service.ProductDetailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;

/**
 * The type Product controller test.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductDetailService productDetailService;

    @Mock
    private ModelMapper modelMapper;

    /**
     * Gets product by name test.
     */
    @Test(expected = ProductNotFoundException.class)
    public void getProductByNameTest() throws ProductNotFoundException {
        ResponseEntity<ProductDetailsResponse> productDetailsResponseResponseEntity = productController.getProductByName("Apple");
        System.out.println("ProductControllerTest.getProductByNameTest" + productDetailsResponseResponseEntity.getStatusCode());
        Assert.assertNotNull(productDetailsResponseResponseEntity);
        Assert.assertEquals(200, productDetailsResponseResponseEntity.getStatusCode().value());
    }


    /**
     * Gets product by name test.
     */
    @Test
    public void getFindProductByName() throws ProductNotFoundException {
        List<ProductDetail> productDetails = new ArrayList<>();
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(1);
        productDetail.setProductName("Apple");
        productDetails.add(productDetail);
        Mockito.when(productDetailService.getProductByName(any())).thenReturn(productDetails);
        ResponseEntity<ProductDetailsResponse> productDetailsResponseResponseEntity = productController.getProductByName("Apple");
        System.out.println("ProductControllerTest.getProductByNameTest" + productDetailsResponseResponseEntity.getStatusCode());
        Assert.assertNotNull(productDetailsResponseResponseEntity);
        Assert.assertEquals(200, productDetailsResponseResponseEntity.getStatusCode().value());
    }

    /**
     * View product details test.
     */
    @Test
    public void viewProductDetailsTest() throws ProductNotFoundException {

        ProductDetail product = new ProductDetail();
        product.setProductId(1);
        product.setProductName("Mobile");
        product.setProductDesc("Mobile Desc");
        Set<ProductRatingDetail> productRatingDetails = new HashSet<>();
        ProductRatingDetail productRatingDetail = new ProductRatingDetail();
        productRatingDetail.setRating(4);
        product.setProductRatingDetail(productRatingDetails);
        List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
        productDetails.add(product);

        List<RatingPojo> storeRatings = new ArrayList<>();
        RatingPojo pojo = new RatingPojo();
        pojo.setStoreName("Amazon");
        pojo.setRating(4);
        storeRatings.add(pojo);
        Mockito.when(this.productDetailService.getProduct(any())).thenReturn(product);
        Mockito.when(this.productDetailService.getStoreRatings(any())).thenReturn(storeRatings);
        ResponseEntity<ProductRatingDtoResponse> productRatingDtoResponseResponseEntity = productController.viewProductDetails("1");
        ProductDetail productDetail = this.productDetailService.getProduct("1");
        Assert.assertNotNull(productDetail);
        Assert.assertEquals(1, productDetail.getProductId());
        Set<ProductRatingDetail> productRatings = productDetail.getProductRatingDetail();
        OptionalDouble avg = productRatings.stream().mapToInt(p -> p.getRating()).average();
        ProductRatingDetailDto ratingDetailDto = new ProductRatingDetailDto();
        List<ProductRatingDetailDto> productRatingDetailDtos = productRatings.stream().map(p -> {
            ratingDetailDto.setRating(p.getRating());
            ratingDetailDto.setStoreName(p.getStoreDetail().getStoreName());
            ratingDetailDto.setRatingId(p.getRatingId());
            return ratingDetailDto;
        }).collect(Collectors.toList());
        Assert.assertNotNull(productRatingDetailDtos);
    }

    /**
     * Save product test.
     */
    @Test
    public void saveProductTest() {
        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        productDetailsDto.setProductId(4);
        productDetailsDto.setProductDesc("test");
        productDetailsDto.setProductName("test1");
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(201);
        apiResponse.setMessage("success");

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductName("test1");
        productDetail.setProductDesc("test");
        Mockito.when(this.productDetailService.saveProductDetails(any())).thenReturn(apiResponse);
        ApiResponse apiResponse2 = this.productDetailService.saveProductDetails(productDetail);
        ResponseEntity<ApiResponse> saveProductDetails = this.productController.saveProductDetails(productDetailsDto);
        Assert.assertEquals(201, saveProductDetails.getStatusCode().value());
    }

    /**
     * Save method for check valid exceptions
     */
    @Test
    public void saveProductValidCheckTest() {
        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        productDetailsDto.setProductId(4);
        productDetailsDto.setProductDesc("test");
        productDetailsDto.setProductName("");
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(400);
        apiResponse.setMessage("Error");

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductName("");
        productDetail.setProductDesc("test");
        Mockito.when(this.productDetailService.saveProductDetails(any())).thenReturn(apiResponse);
        ApiResponse apiResponse2 = this.productDetailService.saveProductDetails(productDetail);
        ResponseEntity<ApiResponse> saveProductDetails = this.productController.saveProductDetails(productDetailsDto);
        Assert.assertEquals(201, saveProductDetails.getStatusCode().value());
    }
}
