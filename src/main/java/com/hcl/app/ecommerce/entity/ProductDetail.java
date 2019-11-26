package com.hcl.app.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * The type Product detail.
 */
@Entity
@Table(name = "product_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail implements Serializable {

    /**
     * The Product rating detail.
     */
    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductRatingDetail> productRatingDetail;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(name = "proudct_name")
    private String productName;
    @Column(name = "product_desc")
    private String productDesc;
    @OneToMany(mappedBy = "productDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<StoreDetail> storeDetails;

}
