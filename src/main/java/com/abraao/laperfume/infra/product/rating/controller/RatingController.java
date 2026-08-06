package com.abraao.laperfume.infra.product.rating.controller;

import com.abraao.laperfume.infra.product.rating.dto.request.RatingRequestDto;
import com.abraao.laperfume.infra.product.rating.dto.response.RatingReponseDto;
import com.abraao.laperfume.domain.product.rating.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService, ModelMapper mapper) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public RatingReponseDto createRating(@RequestBody RatingRequestDto ratingRequestDto) {
        return ratingService.createRating(ratingRequestDto);
    }
}
