package com.abraao.laperfume.infra.profile.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfileResDto {

    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String cpf;

    @NotNull
    private String birthYear;
}
