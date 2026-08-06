package com.abraao.laperfume.model.product.Specification;

import com.abraao.laperfume.infra.product.product.dto.response.ProductSearch;
import com.abraao.laperfume.model.product.product.Product;
import org.springframework.data.jpa.domain.Specification;

public interface ProductSpec {
    Specification<Product> specification(ProductSearch productSearch);
}
