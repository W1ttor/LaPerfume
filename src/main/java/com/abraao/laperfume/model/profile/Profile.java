package com.abraao.laperfume.model.profile;

import com.abraao.laperfume.model.product.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
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
    private List<Product> products;

    public Profile() {

    }
}
