package com.hcl.app.ecommerce.service;

import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.UserDetail;

/**
 * The interface User detail service.
 */
public interface UserDetailService {
    /**
     * Save user api response.
     *
     * @param userDetail the user detail
     * @return the api response
     */
    public ApiResponse saveUser(UserDetail userDetail);

    /**
     * Gets user.
     *
     * @param userDetail the user detail
     * @return the user
     */
    public boolean getUser(UserDetail userDetail);
}
