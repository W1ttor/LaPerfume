package com.abraao.laperfume.model.product.Specification.strategy.orderBy;

import com.abraao.laperfume.model.product.product.Product;
import org.springframework.data.jpa.domain.Specification;

public interface OrderByStrategy {
    Specification<Product> orderBy(String orderBy);
}
