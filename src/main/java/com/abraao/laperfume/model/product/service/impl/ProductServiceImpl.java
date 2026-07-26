package com.abraao.laperfume.model.product.service.impl;

import com.abraao.laperfume.infra.product.dto.request.ProductReqDto;
import com.abraao.laperfume.infra.product.dto.response.ProductResDto;
import com.abraao.laperfume.infra.product.repository.ProductRepository;
import com.abraao.laperfume.infra.profile.repository.ProfileRepository;
import com.abraao.laperfume.model.product.Product;
import com.abraao.laperfume.model.product.Specification.ProductSpec;
import com.abraao.laperfume.model.product.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service @Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProfileRepository profileRepository;
    private final ModelMapper mapper;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository,  ModelMapper mapper, ProfileRepository profileRepository) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.profileRepository = profileRepository;
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
    public List<ProductResDto> findAllProducts(String name , Pageable pageable) {

        Specification<Product> spec = Specification.where(ProductSpec.containsName(name));

        return productRepository.findAll(spec, pageable)
                .stream()
                .map(product -> mapper.map(product, ProductResDto.class))
                .toList();
    }

    @Override
    public void deleteProduct(ProductReqDto productReqDto) {
    }

    @Override
    public ProductResDto addProductToProfile(String idProduct, String idProfile) {

        Product product = productRepository.findById(UUID.fromString(idProduct)).
                orElseThrow();

        product.addProductToProfile(profileRepository.findById(idProfile).orElseThrow());

        productRepository.save(product);
        return mapper.map(product, ProductResDto.class);
    }


}
