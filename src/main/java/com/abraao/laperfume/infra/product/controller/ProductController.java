package com.abraao.laperfume.infra.product.controller;

import com.abraao.laperfume.infra.product.repository.ProductRepository;
import com.abraao.laperfume.model.product.Product;
import com.abraao.laperfume.model.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> findAll() {
        return productService.findAll();
    }

}
