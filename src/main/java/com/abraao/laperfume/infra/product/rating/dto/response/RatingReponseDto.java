package com.abraao.laperfume.infra.product.rating.dto.response;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class RatingReponseDto {

    private String id;
    private String comment;
    private Integer rating;
    private String nameProfile;

}
