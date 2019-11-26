package com.hcl.app.ecommerce.repository;

import com.hcl.app.ecommerce.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User detail repository.
 */
@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {
    /**
     * Find by user name user detail.
     *
     * @param userName the user name
     * @return the user detail
     */
    UserDetail findByUserName(String userName);
}
