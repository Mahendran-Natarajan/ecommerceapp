package com.hcl.app.ecommerce.service.impl;

import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.UserDetail;
import com.hcl.app.ecommerce.repository.UserDetailRepository;
import com.hcl.app.ecommerce.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User detail service.
 * @author manatara
 * @since 27-11-2019
 * @version 1.0
 *
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    /**
     *  save user
     * @param userDetails  holds the user details
     * @return ApiResponse as output
     */
    @Override
    public ApiResponse saveUser(UserDetail userDetails) {
        UserDetail userDetail = userDetailRepository.save(userDetails);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(userDetail.getId() + " saved " + userDetail.getUserName());
        apiResponse.setStatusCode(200);
        return apiResponse;
    }

    /**
     * Get User
     * @param userDetails contains the user details
     * @return true if password is matches, otherwise false
     */
    @Override
    public boolean getUser(UserDetail userDetails) {
        boolean userExists = false ;
        UserDetail userDetail = userDetailRepository.findByUserName(userDetails.getUserName());
        if (userDetail != null &&
            userDetails.getPassword().equals(userDetail.getPassword())) {
                userExists = true;
            }
        return userExists;
    }
}
