package com.abraao.laperfume.infra.product.controller;

import com.abraao.laperfume.infra.product.dto.request.ProductReqDto;
import com.abraao.laperfume.infra.product.dto.response.ProductResDto;
import com.abraao.laperfume.model.product.Product;
import com.abraao.laperfume.model.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResDto> findAll() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResDto findById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResDto create(@RequestBody ProductReqDto productReqDto) {
        return productService.CreateProduct(productReqDto);
    }

    @PutMapping("/{id}")
    public ProductResDto update(@PathVariable String id, @RequestBody ProductReqDto productReqDto) {
        return productService.updateProduct(id, productReqDto);
    }



}
