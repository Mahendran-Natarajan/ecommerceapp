package com.hcl.app.ecommerce.repository;

import com.hcl.app.ecommerce.entity.StoreDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Store detail repository.
 */
@Repository
public interface StoreDetailRepository extends JpaRepository<StoreDetail, Long> {

}
