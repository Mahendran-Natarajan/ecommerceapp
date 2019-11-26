package com.hcl.app.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * The type User detail.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class UserDetail implements Serializable {

    /**
     * The Product rating detail.
     */
    @OneToMany(mappedBy = "userDetails", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductRatingDetail> productRatingDetail;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
}
