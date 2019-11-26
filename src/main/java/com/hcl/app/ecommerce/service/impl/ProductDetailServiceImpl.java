package com.hcl.app.ecommerce.service.impl;

import com.hcl.app.ecommerce.dto.RatingPojo;
import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.ProductDetail;
import com.hcl.app.ecommerce.repository.ProductDetailRepository;
import com.hcl.app.ecommerce.repository.ProductRatingDetailRepository;
import com.hcl.app.ecommerce.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Product detail service.
 */
@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ProductRatingDetailRepository productRatingDetailRepository;

    @Override
    public ProductDetail getProduct(String productId) {
        Optional<ProductDetail> productDetail = productDetailRepository.findById(Long.parseLong(productId));
        if (productDetail.isPresent()) {
            return productDetail.get();
        }
        return null;
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
        ProductDetail productDetail = productDetailRepository.save(productDetails);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(200);
        apiResponse.setMessage("Product stored " + productDetail.getProductId());
        return apiResponse;
    }

}
