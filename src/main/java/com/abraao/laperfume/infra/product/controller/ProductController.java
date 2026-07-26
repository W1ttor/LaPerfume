package com.abraao.laperfume.infra.product.controller;

import com.abraao.laperfume.infra.product.dto.request.ProductReqDto;
import com.abraao.laperfume.infra.product.dto.response.ProductResDto;
import com.abraao.laperfume.model.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
@Tag(name = "Produtos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResDto> findAll(
            @ParameterObject
            @PageableDefault(page = 0, size = 20) Pageable pageable,
            @RequestParam(required = false) String name

    ) {
        return productService.findAllProducts(name ,pageable);
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

    @Operation(description = "Adicionar produto ao Profile")
    @PostMapping("/{id}")
    public ProductResDto addProduct(@PathVariable String id, String idProfile) {
        return productService.addProductToProfile(id, idProfile);
    }


}
