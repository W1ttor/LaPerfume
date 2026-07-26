package com.abraao.laperfume.model.product;

import com.abraao.laperfume.shared.Enum.FragranceOrLine;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
public class FragranceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private FragranceOrLine fragranceOrLine;

    @ManyToMany(mappedBy = "fragranceCategory")
    private List<Product> products;
}
