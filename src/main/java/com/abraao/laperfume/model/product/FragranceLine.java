package com.abraao.laperfume.model.product;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class FragranceLine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;


    @ManyToMany(mappedBy = "fragranceLine")
    private Set<Product> products;
}
