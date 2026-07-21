package com.abraao.laperfume.model.profile;

import com.abraao.laperfume.utils.Enum.EnumLocal;
import com.abraao.laperfume.utils.Enum.States;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter @AllArgsConstructor @NoArgsConstructor
public class Address {

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

}
