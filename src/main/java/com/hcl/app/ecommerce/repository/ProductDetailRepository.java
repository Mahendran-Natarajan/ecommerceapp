package com.hcl.app.ecommerce.repository;

import com.hcl.app.ecommerce.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Product detail repository.
 */
@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    /**
     * Find all by product name contains list.
     *
     * @param productName the product name
     * @return the list
     */
    List<ProductDetail> findAllByProductNameContains(String productName);

}
