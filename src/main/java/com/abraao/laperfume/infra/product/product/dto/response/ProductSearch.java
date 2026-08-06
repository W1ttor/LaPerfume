package com.abraao.laperfume.infra.product.product.dto.response;

import com.abraao.laperfume.shared.Enum.EnumOrderByStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor(force = true)
@AllArgsConstructor
public class ProductSearch {
    private String name;
    private String nameCategory;
    private Double min;
    private Double max;
    private EnumOrderByStrategy enumOrderByStrategy;
}
