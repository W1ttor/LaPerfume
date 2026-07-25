package com.abraao.laperfume.model.product.service.impl;

import com.abraao.laperfume.infra.product.dto.request.ProductReqDto;
import com.abraao.laperfume.infra.product.dto.response.ProductResDto;
import com.abraao.laperfume.infra.product.repository.ProductRepository;
import com.abraao.laperfume.model.product.Product;
import com.abraao.laperfume.model.product.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service @Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository,  ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductResDto CreateProduct(ProductReqDto productReqDto) {
        Product product = Product.builder()
                .name(productReqDto.getName())
                .description(productReqDto.getDescription())
                .image(productReqDto.getImage())
                .ml(productReqDto.getMl())
                .price(productReqDto.getPrice())
                .quantity(productReqDto.getQuantity())
                .gender(productReqDto.getGender())
                .build();

        productRepository.save(product);

        return mapper.map(product, ProductResDto.class);
    }

    @Override
    public ProductResDto updateProduct(String id, ProductReqDto productReqDto) {
        Product product =  mapper.map(productReqDto, Product.class);
        product.setId(UUID.fromString(id));

        productRepository.save(product);

        return mapper.map(product, ProductResDto.class);
    }

    @Override
    public ProductResDto getProductById(String id) {
        Product product = productRepository.findById(UUID.fromString(id))
                .orElseThrow();

        return mapper.map(product, ProductResDto.class);
    }

    @Override
    public List<ProductResDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> mapper.map(product, ProductResDto.class))
                .toList();
    }

    @Override
    public void deleteProduct(ProductReqDto productReqDto) {
    }
}
