package com.abraao.laperfume.model.product.rating.service.impl;

import com.abraao.laperfume.infra.product.rating.dto.request.RatingRequestDto;
import com.abraao.laperfume.infra.product.rating.dto.response.RatingReponseDto;
import com.abraao.laperfume.infra.product.rating.repository.RatingRepository;
import com.abraao.laperfume.model.product.product.Product;
import com.abraao.laperfume.model.product.product.service.ProductService;
import com.abraao.laperfume.model.product.rating.Rating;
import com.abraao.laperfume.model.product.rating.service.RatingService;
import com.abraao.laperfume.model.profile.Profile;
import com.abraao.laperfume.model.profile.Service.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final ProductService productService;
    private final ProfileService profileService;
    private final ModelMapper modelMapper;

    public RatingServiceImpl(RatingRepository ratingRepository, ProductService productService, ProfileService profileService,  ModelMapper modelMapper) {
        this.ratingRepository = ratingRepository;
        this.productService = productService;
        this.profileService = profileService;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public RatingReponseDto createRating(RatingRequestDto rating) {

        Profile profile = modelMapper.map(profileService.findById(rating.getProfileId()), Profile.class);
        Product product = modelMapper.map(productService.getProductById(rating.getProductId()), Product.class);


        Rating ratingEntity = Rating.builder()
                .comment(rating.getComment())
                .rating(rating.getRating())
                .product(product)
                .profile(profile)
                .build();

        ratingRepository.save(ratingEntity);

        return showRating(ratingEntity);
    }

    @Override
    public Rating findById(Integer id) {
        return null;
    }

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating updateRating(Rating rating) {
        return null;
    }

    @Override
    public void deleteRating(Rating rating) {

    }


    private RatingReponseDto showRating(Rating rating) {

        Profile profile = rating.getProfile();

        return RatingReponseDto.builder()
                .id(rating.getId().toString())
                .comment(rating.getComment())
                .rating(rating.getRating())
                .nameProfile(profile.getName())
                .build();
    }

}
