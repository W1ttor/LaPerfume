package com.abraao.laperfume.model.address;

import com.abraao.laperfume.model.profile.Profile;
import com.abraao.laperfume.utils.Enum.EnumLocal;
import com.abraao.laperfume.utils.Enum.States;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter @AllArgsConstructor @NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fullName;

    private Integer phoneNumber;

    private Integer cep;

    @Enumerated(EnumType.STRING)
    private States states;

    private String district;

    private String street;

    private Integer number;

    private String supplement;

    @Enumerated(EnumType.STRING)
    private EnumLocal ResidentialOrCommercial;

    @OneToOne
    private Profile profile;



}
