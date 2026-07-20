package com.abraao.laperfume.model.product.service.impl;

import com.abraao.laperfume.infra.product.repository.ProductRepository;
import com.abraao.laperfume.model.product.Product;
import com.abraao.laperfume.model.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
