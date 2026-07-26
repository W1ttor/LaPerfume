package com.abraao.laperfume.model.product.service;

import com.abraao.laperfume.infra.product.dto.request.ProductReqDto;
import com.abraao.laperfume.infra.product.dto.response.ProductResDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {
    ProductResDto CreateProduct(ProductReqDto productReqDto);
    ProductResDto updateProduct(String id, ProductReqDto productReqDto);
    ProductResDto getProductById(String id);
    List<ProductResDto> findAllProducts(String spec, Pageable pageable);
    void deleteProduct(ProductReqDto productReqDto);

    ProductResDto addProductToProfile(String id, String idProduct);


    //Fragrance

}
