package com.hcl.app.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type User details dto.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    private Integer id;
    private String userName;
    private String password;
}
