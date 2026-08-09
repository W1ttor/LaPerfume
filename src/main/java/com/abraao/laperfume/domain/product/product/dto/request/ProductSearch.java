package com.abraao.laperfume.domain.product.product.dto.response;

import com.abraao.laperfume.shared.Enum.EnumOrderByStrategy;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor(force = true)
@AllArgsConstructor
public class ProductSearch {

    @Schema(description = "Verificar se a algum produto com tal nome")
    private String name;

    @Schema(description = "Verificar se a algum produto com tal categoria")
    private String nameCategory;

    @Schema(description = "Verificar produtos com o valor minino de")
    private Double min;

    @Schema(description = "Verificar produtos com valor maximo de ")
    private Double max;

    @Schema(description = "Verificar produtos por ordem de")
    private EnumOrderByStrategy enumOrderByStrategy;
}
