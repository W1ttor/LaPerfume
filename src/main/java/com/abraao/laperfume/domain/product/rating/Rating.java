package com.abraao.laperfume.model.product.rating;

import com.abraao.laperfume.model.product.product.Product;
import com.abraao.laperfume.model.profile.Profile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor @NoArgsConstructor(force = true) @Getter
@Builder @Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String comment;

    @NotNull
    private Integer rating;

    private String imagePath;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public void addProfile(Profile profile) {
        profile.getRatings().add(this);
    }

    public void removeProfile(Profile profile) {
        profile.getRatings().remove(this);
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;

    public void addProduct(Product product) {
        product.getRatings().add(this);
    }

    public void removeProduct(Product product) {
        product.getRatings().remove(this);
    }
}
