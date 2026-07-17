package com.abraao.laperfume.model.product;

import com.abraao.laperfume.model.cart.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private String image;
    private Integer ml;
    private Double price;
    private Integer quantity;

    @ManyToMany
    @JoinTable(
            name = "prod_cart",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    private Set<Cart> cart;

    @ManyToMany
    @JoinTable(
            name = "prod_categ",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "fragancecategory_id")
    )
    private Set<FragranceCategory> fragrancecategory;

    @ManyToMany
    @JoinTable(
            name = "prod_line",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "fraganceline_id")
    )
    private Set<FragranceLine> fragranceLine;

}
