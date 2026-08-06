package com.abraao.laperfume.model.product.Specification.strategy.orderBy.stategy;

import com.abraao.laperfume.model.product.product.Product;
import com.abraao.laperfume.model.product.Specification.strategy.orderBy.OrderByStrategy;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component("sortbylowestprice")
public class SortByLowestPrice implements OrderByStrategy {
    @Override
    public Specification<Product> orderBy(String orderBy) {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("price")));
            return criteriaBuilder.conjunction();
        };
    }
}
