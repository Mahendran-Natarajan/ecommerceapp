package com.hcl.app.ecommerce.web;

import com.hcl.app.ecommerce.dto.ProductDetailsDto;
import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.dto.response.ProductDetailsResponse;
import com.hcl.app.ecommerce.dto.response.ProductRatingDtoResponse;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.entity.ProductRatingDetail;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Test
    public void getProductByNameTest() {
        ResponseEntity<ProductDetailsResponse> productDetailsResponseResponseEntity = productController.getProductByName("Apple");
        System.out.println("ProductControllerTest.getProductByNameTest" + productDetailsResponseResponseEntity.getStatusCode());
        Assert.assertNotNull(productDetailsResponseResponseEntity);
        Assert.assertEquals(200, productDetailsResponseResponseEntity.getStatusCode().value());
    }

    /**
     * View product details test.
     */
    @Test
    public void viewProductDetailsTest() {

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
        Mockito.when(productDetailService.getProduct(any())).thenReturn(product);
        ResponseEntity<ProductRatingDtoResponse> productRatingDtoResponseResponseEntity = productController.viewProductDetails("1");
        ProductDetail productDetail = this.productDetailService.getProduct("1");
        Assert.assertNotNull(productDetail);
        Assert.assertEquals(1, productDetail.getProductId());
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
}
