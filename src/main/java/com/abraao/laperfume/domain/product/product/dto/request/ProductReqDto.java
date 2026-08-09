package com.abraao.laperfume.infra.product.product.dto.request;

import com.abraao.laperfume.shared.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ProductReqDto {

    @NotBlank @NotNull
    private String name;

    @NotBlank @NotNull
    private String description;

    private String imagePath;

    @NotBlank @NotNull
    private Integer ml;

    @NotBlank @NotNull
    private Double price;

    @NotBlank @NotNull
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @NotBlank @NotNull
    private Gender gender;

    private List<String> idCategory;
}
