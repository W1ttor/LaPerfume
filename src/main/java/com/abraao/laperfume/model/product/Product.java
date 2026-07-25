package com.abraao.laperfume.model.product;

import com.abraao.laperfume.model.profile.Profile;
import com.abraao.laperfume.shared.Enum.Gender;
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

    @ManyToMany(mappedBy = "products")
    private Set<Profile> profiles;

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
