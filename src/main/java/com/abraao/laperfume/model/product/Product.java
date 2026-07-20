package com.abraao.laperfume.model.product;

import com.abraao.laperfume.model.cart.Cart;
import com.abraao.laperfume.utils.Enum.Gender;
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

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany
    @JoinTable(
            name = "prod_cart",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    private Set<Cart> cart;

    public void addCart(Cart cart) {
        this.cart.add(cart);
        cart.getProduct().add(this);
    }

    public void removeCart(Cart cart) {
        this.cart.remove(cart);
        cart.getProduct().remove(this);
    }

    @ManyToMany
    @JoinTable(
            name = "prod_categ",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "fragancecategory_id")
    )
    private Set<FragranceCategory> fragranceCategory;

    public void addFragranceCategory(FragranceCategory fragranceCategory) {
        this.fragranceCategory.add(fragranceCategory);
        fragranceCategory.getProducts().add(this);
    }

    public void removeFragranceCategory(FragranceCategory fragranceCategory) {
        this.fragranceCategory.remove(fragranceCategory);
        fragranceCategory.getProducts().remove(this);
    }

    @ManyToMany
    @JoinTable(
            name = "prod_line",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "fraganceline_id")
    )
    private Set<FragranceLine> fragranceLine;

    public void addFragranceLine(FragranceLine fragranceLine) {
        this.fragranceLine.add(fragranceLine);
        fragranceLine.getProducts().add(this);
    }

    public void removeFragranceLine(FragranceLine fragranceLine) {
        this.fragranceLine.remove(fragranceLine);
        fragranceLine.getProducts().remove(this);
    }

}
