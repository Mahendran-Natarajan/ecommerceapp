package com.hcl.app.ecommerce.service;

import com.hcl.app.ecommerce.dto.RatingPojo;
import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.exception.ProductNotFoundException;

import java.util.List;

/**
 * The interface Product detail service.
 */
public interface ProductDetailService {

    /**
     * Save product details api response.
     *
     * @param productDetail the product detail
     * @return the api response
     */
    ApiResponse saveProductDetails(ProductDetail productDetail);

    /**
     * Gets product.
     *
     * @param productId the product id
     * @return the product
     */
    ProductDetail getProduct(String productId) throws ProductNotFoundException;

    /**
     * Gets product by name.
     *
     * @param productName the product name
     * @return the product by name
     */
    List<ProductDetail> getProductByName(String productName);

    /**
     * Gets store ratings.
     *
     * @param productId the product id
     * @return the store ratings
     */
    public List<RatingPojo> getStoreRatings(Long productId);

}
