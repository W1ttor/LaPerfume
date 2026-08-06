package com.abraao.laperfume.model.product.category;

import com.abraao.laperfume.model.product.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity @Data
@Getter @Builder
@AllArgsConstructor @NoArgsConstructor(force = true)
public class FragranceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "fragranceCategories")
    private List<Product> products = new ArrayList<>();

    public void changeName(String newName) {
        this.name = newName;
    }
}
