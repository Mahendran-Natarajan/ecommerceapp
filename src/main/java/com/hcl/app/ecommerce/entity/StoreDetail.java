package com.hcl.app.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * The type Store detail.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store_details")
public class StoreDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private long storeId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "store_desc")
    private String storeDesc;

    @Column(name = "store_location")
    private String storeLocation;

    @Column(name = "storePrice")
    private Double storePrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private ProductDetail productDetails;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storeDetail")
    private Set<ProductRatingDetail> productRatingDetail;
}
