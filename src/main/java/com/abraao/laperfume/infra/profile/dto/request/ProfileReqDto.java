package com.abraao.laperfume.infra.profile.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ProfileReqDto {
    @NotBlank
    @Schema(example = "Kamila")
    private String name;

    @Schema(example = "kamila@gmail.com")
    @NotNull @Column(unique = true) @Email
    private String email;

    @Schema(example = "694.255.950-46")
    @NotNull @Column(unique = true) @CPF
    private String cpf;

    @NotNull
    @Schema(example = "06-03-2005")
    @Past(message = "A data inserida deve ser do passado")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthYear;
}
