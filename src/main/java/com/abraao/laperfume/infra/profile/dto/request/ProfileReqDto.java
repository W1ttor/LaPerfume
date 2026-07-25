package com.abraao.laperfume.infra.profile.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class ProfileReqDto {
    @NotBlank
    private String name;

    @NotNull @Column(unique = true) @Email
    private String email;

    @NotNull @Column(unique = true) @CPF
    private String cpf;

    @NotBlank
    private String birthYear;
}
