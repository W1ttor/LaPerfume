package com.abraao.laperfume.model.product.Specification.strategy.orderBy;

import com.abraao.laperfume.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderByService {

    @Autowired
    private Map<String, OrderByStrategy> specifications;

    public Specification<Product> getOrderBy(String orderBy) {

        OrderByStrategy strategies = specifications.get(orderBy);

        return strategies.orderBy(orderBy);
    }
}
