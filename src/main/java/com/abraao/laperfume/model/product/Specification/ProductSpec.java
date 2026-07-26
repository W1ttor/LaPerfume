package com.abraao.laperfume.model.product.Specification;

import ch.qos.logback.core.util.StringUtil;
import com.abraao.laperfume.infra.product.dto.response.ProductResDto;
import com.abraao.laperfume.model.product.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class ProductSpec {

    public static Specification<Product> containsName(String productName) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(productName)) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + productName.toLowerCase() + "%");
        };
    }
}
