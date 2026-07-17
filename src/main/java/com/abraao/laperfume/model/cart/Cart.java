package com.abraao.laperfume.model.cart;

import com.abraao.laperfume.model.product.Product;
import com.abraao.laperfume.model.profile.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter @AllArgsConstructor @NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private Profile  profile;

    @ManyToMany(mappedBy = "cart")
    private Set<Product> product;

}
