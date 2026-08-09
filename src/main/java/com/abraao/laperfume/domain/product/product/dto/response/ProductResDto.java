package com.abraao.laperfume.infra.product.product.dto.response;

import com.abraao.laperfume.shared.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor(force = true)
@Builder
public class ProductResDto {

    @NotNull
    private UUID id;

    @NotBlank
    @NotNull
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

    public ProductResDto(UUID id, String name, String description, String imagePath, Integer ml, Double price, Integer quantity, Gender gender) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.ml = ml;
        this.price = price;
        this.quantity = quantity;
        this.gender = gender;
    }
}
