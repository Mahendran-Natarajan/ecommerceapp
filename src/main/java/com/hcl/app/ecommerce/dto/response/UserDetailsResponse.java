package com.hcl.app.ecommerce.dto.response;

import com.hcl.app.ecommerce.dto.UserDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type User details response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsResponse extends ApiResponse {

    private List<UserDetailsDto> userDetailsDtos;

}
