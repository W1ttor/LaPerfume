package com.abraao.laperfume.infra.product.rating.dto.request;

import lombok.Data;

@Data
public class RatingRequestDto {

    private String comment;
    private Integer rating;
    private String profileId;
    private String productId;

}
