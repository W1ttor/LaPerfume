package com.abraao.laperfume.model.profile;

import com.abraao.laperfume.model.product.product.Product;
import com.abraao.laperfume.model.product.rating.Rating;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @Builder
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private String id;

    @NotBlank
    private String name;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @CPF
    @NotNull
    @Column(unique = true)
    private String cpf;

    @NotNull
    private LocalDate birthYear;

    private Address address;

    private Boolean inactive;

    private Boolean deleted;

    @ManyToMany
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @Builder.Default
    private List<Product> products = new ArrayList<>();


    @OneToMany
    @JoinTable(
            name = "rating_profile",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "rating_id")
    )
    @Builder.Default
    private List<Rating> ratings =  new ArrayList<>();

    public List<Rating> getRatings() {
        if (ratings == null) {
            ratings = new ArrayList<>();
        }
        return ratings;
    }

    public Profile() {

    }
}
