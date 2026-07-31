package com.abraao.laperfume.model.product;

import com.abraao.laperfume.model.profile.Profile;
import com.abraao.laperfume.shared.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @Getter
@Data
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
    private Double discount;
    private Integer sold;
    private Double rated;


    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(mappedBy = "products")
    @Builder.Default
    private List<Profile> profiles =  new ArrayList<>();

    public void addProductToProfile(Profile profile) {
        this.profiles.add(profile);
        profile.getProducts().add(this);
    }

    public void removeProductFromProfile(Profile profile) {
        this.profiles.remove(profile);
        profile.getProducts().remove(this);
    }

    @ManyToMany
    @JoinTable(
            name = "prod_categ",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Builder.Default
    private List<FragranceCategory> fragranceCategories = new ArrayList<>();

    public void addFragranceCategory(FragranceCategory fragranceCategory) {
        this.fragranceCategories.add(fragranceCategory);
        fragranceCategory.getProducts().add(this);
    }

    public void removeFragranceCategory(FragranceCategory fragranceCategory) {
        this.fragranceCategories.remove(fragranceCategory);
        fragranceCategory.getProducts().remove(this);
    }

}
