package com.abraao.laperfume.model.product.rating.service;

import com.abraao.laperfume.infra.product.rating.dto.request.RatingRequestDto;
import com.abraao.laperfume.infra.product.rating.dto.response.RatingReponseDto;
import com.abraao.laperfume.model.product.rating.Rating;

import java.util.List;

public interface RatingService {
    public RatingReponseDto createRating(RatingRequestDto ratingRequestDto);
    public Rating findById(Integer id);
    public List<Rating> findAll();
    public Rating updateRating(Rating rating);
    public void deleteRating(Rating rating);


}
