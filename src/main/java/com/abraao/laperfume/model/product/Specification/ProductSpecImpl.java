package com.abraao.laperfume.model.product.Specification;

import com.abraao.laperfume.infra.product.dto.response.ProductSearch;
import com.abraao.laperfume.model.product.FragranceCategory;
import com.abraao.laperfume.model.product.Product;
import com.abraao.laperfume.model.product.Specification.strategy.orderBy.OrderByService;
import com.abraao.laperfume.shared.Enum.EnumOrderByStrategy;
import jakarta.persistence.criteria.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ProductSpecImpl implements ProductSpec{

    @Autowired
    private OrderByService orderByService;

    @Override
    public Specification<Product> specification(ProductSearch productSearch) {
        Specification<Product> spec = Specification.where(containsName(productSearch.getName()));

        if (!(hasCategoryName(productSearch.getNameCategory()) == null)) {
            spec = spec.and(hasCategoryName(productSearch.getNameCategory()));
        }
        if (!(priceRange(productSearch.getMin(), productSearch.getMax()) == null)){
            spec = spec.and(priceRange(productSearch.getMin(), productSearch.getMax()));
        }
        if (!(orderBy(productSearch.getEnumOrderByStrategy()) == null)){
            spec = spec.and(orderBy(productSearch.getEnumOrderByStrategy()));
        }

        return spec;
    }

    private Specification<Product> containsName(String productName) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(productName)) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + productName.toLowerCase() + "%");
        };
    }

    private Specification<Product> hasCategoryName(String categoryName) {
        if (categoryName == null || categoryName.isEmpty()) return null;

        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(categoryName)) return null;

            query.distinct(true);

            Join<Product, FragranceCategory> categoryJoin = root.join("fragranceCategories");


            return criteriaBuilder.like(
                    criteriaBuilder.lower(categoryJoin.get("name")), "%" + categoryName.toLowerCase() + "%"
            );
        };
    }

    private Specification<Product> priceRange(Double min, Double max) {
        if (min == null && max == null) return null;

        if (min == null){
            return ((root, query, criteriaBuilder) ->{
                return criteriaBuilder.between(root.get("price"), 0.0, max);
            });
        }

        return ((root, query, criteriaBuilder) ->{
            return criteriaBuilder.between(root.get("price"), min, max);
        });
    }

    private Specification<Product> orderBy(EnumOrderByStrategy enumOrderByStrategy) {
        return orderByService.getOrderBy(enumOrderByStrategy.getValue());
    }
}
