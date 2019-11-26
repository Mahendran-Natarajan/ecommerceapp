package com.hcl.app.ecommerce.repository;

import com.hcl.app.ecommerce.dto.RatingPojo;
import com.hcl.app.ecommerce.entity.ProductRatingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Product rating detail repository.
 */
@Repository
public interface ProductRatingDetailRepository extends JpaRepository<ProductRatingDetail, Long> {

    /**
     * View ratings by store product list.
     *
     * @param proudctId the proudct id
     * @return the list
     */
    @Query("SELECT new com.hcl.app.ecommerce.dto.RatingPojo(AVG(PRD.rating), PRD.storeDetail.storeName)   FROM ProductRatingDetail PRD WHERE PRD.productDetail.productId = :productId GROUP BY PRD.storeDetail.storeId")
    List<RatingPojo> viewRatingsByStoreProduct(@Param("productId") Long proudctId);

}
