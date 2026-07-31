package com.abraao.laperfume.model.product.service.impl;

import com.abraao.laperfume.infra.product.dto.request.ProductReqDto;
import com.abraao.laperfume.infra.product.dto.response.ProductResDto;
import com.abraao.laperfume.infra.product.dto.response.ProductSearch;
import com.abraao.laperfume.infra.product.repository.ProductRepository;
import com.abraao.laperfume.infra.profile.repository.ProfileRepository;
import com.abraao.laperfume.model.product.FragranceCategory;
import com.abraao.laperfume.model.product.Product;
import com.abraao.laperfume.model.product.Specification.ProductSpecImpl;
import com.abraao.laperfume.model.product.service.FragranceCategoryService;
import com.abraao.laperfume.model.product.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final FragranceCategoryService fragranceCategoryService;
    private final ModelMapper mapper;
    private final ProductSpecImpl productSpec;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository,  ModelMapper mapper, ProfileRepository profileRepository, FragranceCategoryService fragranceCategoryService, ProductSpecImpl productSpec) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.profileRepository = profileRepository;
        this.fragranceCategoryService = fragranceCategoryService;
        this.productSpec = productSpec;
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

        if (!productReqDto.getIdCategory().isEmpty()) {
            productReqDto.getIdCategory().forEach(
                    id -> {
                        product.addFragranceCategory(mapper.map(fragranceCategoryService.findCategoryById(id),  FragranceCategory.class));
                    });
        }

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
    public List<ProductResDto> findAllProducts(ProductSearch productSearch, Pageable pageable) {

        Specification<Product> spec = Specification.where(productSpec.specification(productSearch));

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
