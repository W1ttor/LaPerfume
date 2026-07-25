package com.abraao.laperfume.model.product.service;

import com.abraao.laperfume.infra.product.dto.request.ProductReqDto;
import com.abraao.laperfume.infra.product.dto.response.ProductResDto;
import com.abraao.laperfume.model.product.Product;

import java.util.List;

public interface ProductService {
    ProductResDto CreateProduct(ProductReqDto productReqDto);
    ProductResDto updateProduct(String id, ProductReqDto productReqDto);
    ProductResDto getProductById(String id);
    List<ProductResDto> findAllProducts();
    void deleteProduct(ProductReqDto productReqDto);
}
