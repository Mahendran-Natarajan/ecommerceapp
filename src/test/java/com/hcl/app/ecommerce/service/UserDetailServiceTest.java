package com.hcl.app.ecommerce.service;

import com.hcl.app.ecommerce.dto.response.ApiResponse;
import com.hcl.app.ecommerce.entity.UserDetail;
import com.hcl.app.ecommerce.repository.UserDetailRepository;
import com.hcl.app.ecommerce.service.impl.UserDetailServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

/**
 * The type User detail service test.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDetailServiceTest {

    @InjectMocks
    private UserDetailServiceImpl userDetailService;

    @Mock
    private UserDetailRepository userDetailRepository;

    /**
     * Test get user positive.
     */
    @Test
    public void testGetUserPositive() {
        UserDetail userDetails = new UserDetail();
        userDetails.setId(1);
        userDetails.setUserName("root");
        userDetails.setPassword("root");
        Mockito.when(userDetailRepository.findByUserName(any())).thenReturn(userDetails);
        boolean userFlag = userDetailService.getUser(userDetails);
        Assert.assertTrue(userFlag);
    }


    /**
     * Test get user negative.
     */
    @Test
    public void testGetUserNegative() {
        UserDetail userDetails = new UserDetail();
        userDetails.setId(1);
        userDetails.setUserName("root");
        userDetails.setPassword("root");
        Mockito.when(userDetailRepository.findByUserName(any())).thenReturn(userDetails);

        UserDetail userDetail2 = new UserDetail();
        userDetail2.setId(2);
        userDetail2.setUserName("root2");
        userDetail2.setPassword("root2");

        boolean userFlag = userDetailService.getUser(userDetail2);
        Assert.assertFalse(userFlag);
    }

    /**
     * Test save user.
     */
    @Test
    public void testSaveUser() {
        UserDetail userDetails = new UserDetail();
        userDetails.setId(1);
        userDetails.setUserName("root");
        userDetails.setPassword("root");

        Mockito.when(userDetailRepository.save(any())).thenReturn(userDetails);
        ApiResponse saveResponse = userDetailService.saveUser(userDetails);
        Assert.assertNotNull(saveResponse);
        Assert.assertEquals(200, saveResponse.getStatusCode());
    }
}