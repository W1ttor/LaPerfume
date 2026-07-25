package com.abraao.laperfume.model.profile;

import com.abraao.laperfume.shared.Enum.EnumLocal;
import com.abraao.laperfume.shared.Enum.States;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter @AllArgsConstructor @NoArgsConstructor
public class Address {

    @NotBlank
    private String fullName;

    @NotBlank
    private Integer phoneNumber;

    @NotBlank
    private Integer cep;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private States states;

    @NotBlank
    private String district;

    @NotBlank
    private String street;

    @NotBlank
    private Integer number;

    private String supplement;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private EnumLocal ResidentialOrCommercial;

}
