package com.abraao.laperfume.model.profile;

import com.abraao.laperfume.model.address.Address;
import com.abraao.laperfume.model.cart.Cart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private Integer cpf;
    private Integer birthYear;

    @OneToOne
    private Address address;

    @OneToOne
    private Cart cart;



}
