package com.hcl.app.ecommerce.web;

import com.hcl.app.ecommerce.dto.ProductDetailsDto;
import com.hcl.app.ecommerce.dto.ProductRatingDetailDto;
import com.hcl.app.ecommerce.dto.RatingPojo;
import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.dto.response.ProductDetailsResponse;
import com.hcl.app.ecommerce.dto.response.ProductRatingDtoResponse;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.exception.ProductNotFoundException;
import com.hcl.app.ecommerce.service.ProductDetailService;
import com.hcl.app.ecommerce.util.Constant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Product controller - all the product related function will be written here
 *  @author manatara
 *  @since 27-11-2019
 *  @version 1.0
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDetailService productDetailService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Gets product by name.
     *
     * @param productName the product name
     * @return the product details as response entity
     */
    @GetMapping("/product-by-name/{productName}")
    public ResponseEntity<ProductDetailsResponse> getProductByName(@PathVariable @Valid String productName) throws ProductNotFoundException {
        List<ProductDetail> productDetails = this.productDetailService.getProductByName(productName);
        if (productDetails.size() > 0) {
            List<ProductDetailsDto> productDetailsDtos = productDetails.stream().map(this::convertEntityToDto).collect(Collectors.toList());
            ProductDetailsResponse response = new ProductDetailsResponse();
            response.setProductDetailsDtos(productDetailsDtos);
            response.setStatusCode(Constant.SUCCESS_CODE);
            response.setMessage(Constant.SUCCESS_MESSAGE);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ProductNotFoundException(Constant.PRODUCT_NOT_FOUND);
        }
    }

    /**
     * View product details response entity.
     *
     * @param productId the product id
     * @return the response entity of product rating
     */
    @GetMapping("view-product/{productId}")
    public ResponseEntity<ProductRatingDtoResponse> viewProductDetails(@PathVariable String productId) {
        ProductDetail productDetail = this.productDetailService.getProduct(productId);
        List<RatingPojo> storeRatings = this.productDetailService.getStoreRatings(productDetail.getProductId());

        ProductDetailsDto dto = convertEntityToDto(productDetail);
        List<ProductRatingDetailDto> productRatingDetailDtos = new ArrayList<>();
        storeRatings.forEach(ratingPojo -> {
            ProductRatingDetailDto productRatingDetailDto = new ProductRatingDetailDto();
            productRatingDetailDto.setRating(ratingPojo.getRating());
            productRatingDetailDto.setStoreName(ratingPojo.getStoreName());
            productRatingDetailDtos.add(productRatingDetailDto);
        });


        List<ProductDetailsDto> dtos = new ArrayList<>();
        dtos.add(dto);

        ProductDetailsResponse response = new ProductDetailsResponse();
        response.setProductDetailsDtos(dtos);

        ProductRatingDtoResponse productRatingDtoResponse = new ProductRatingDtoResponse();
        productRatingDtoResponse.setProductRatingDetailDtos(productRatingDetailDtos);
        productRatingDtoResponse.setProductDetailsDtos(dtos);

        productRatingDtoResponse.setStatusCode(Constant.SUCCESS_CODE);
        productRatingDtoResponse.setMessage(Constant.SUCCESS_MESSAGE);
        return new ResponseEntity<>(productRatingDtoResponse, HttpStatus.OK);
    }

    /**
     * Save product details response entity.
     *
     * @param productDetailsDto the product details dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<ApiResponse> saveProductDetails(@RequestBody @Valid ProductDetailsDto productDetailsDto) {
        ProductDetail productDetail = convertToEntity(productDetailsDto);
        ApiResponse apiResponse = this.productDetailService.saveProductDetails(productDetail);
        apiResponse.setMessage(Constant.SUCCESS_MESSAGE);
        apiResponse.setStatusCode(Constant.SUCCESS_CODE);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    private ProductDetail convertToEntity(ProductDetailsDto productDetailsDto) {
        return modelMapper.map(productDetailsDto, ProductDetail.class);
    }

    private ProductDetailsDto convertEntityToDto(ProductDetail productDetail) {
        return modelMapper.map(productDetail, ProductDetailsDto.class);
    }
}
