package com.abraao.laperfume.model.product.product.service;

import com.abraao.laperfume.infra.product.product.dto.request.ProductReqDto;
import com.abraao.laperfume.infra.product.product.dto.response.ProductResDto;
import com.abraao.laperfume.infra.product.product.dto.response.ProductSearch;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResDto CreateProduct(ProductReqDto productReqDto);
    ProductResDto updateProduct(String id, ProductReqDto productReqDto);
    ProductResDto getProductById(String id);
    List<ProductResDto> findAllProducts(ProductSearch productSearch, Pageable pageable);
    void deleteProduct(ProductReqDto productReqDto);

    ProductResDto addProductToProfile(String id, String idProduct);

    //Fragrance

}
