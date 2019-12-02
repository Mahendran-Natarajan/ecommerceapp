package com.hcl.app.ecommerce.service.impl;

import com.hcl.app.ecommerce.dto.RatingPojo;
import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.exception.ProductNotFoundException;
import com.hcl.app.ecommerce.repository.ProductDetailRepository;
import com.hcl.app.ecommerce.repository.ProductRatingDetailRepository;
import com.hcl.app.ecommerce.service.ProductDetailService;
import com.hcl.app.ecommerce.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Product detail service.
 * @author manatara
 * @since 27-11-2019
 * @version 1.0
 */
@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ProductRatingDetailRepository productRatingDetailRepository;

    @Override
    public ProductDetail getProduct(String productId) throws ProductNotFoundException {
        Optional<ProductDetail> productDetail = productDetailRepository.findById(Long.parseLong(productId));
        if (productDetail.isPresent()) {
            return productDetail.get();
        } else {
            throw new ProductNotFoundException(Constant.PRODUCT_NOT_FOUND);
        }
    }

    @Override
    public List<RatingPojo> getStoreRatings(Long productId) {
        return this.productRatingDetailRepository.viewRatingsByStoreProduct(productId);

    }

    @Override
    public List<ProductDetail> getProductByName(String productName) {
        return this.productDetailRepository.findAllByProductNameContains(productName);
    }

    @Override
    public ApiResponse saveProductDetails(ProductDetail productDetails) {
        productDetailRepository.save(productDetails);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(200);
        apiResponse.setMessage("Success");
        return apiResponse;
    }

}
