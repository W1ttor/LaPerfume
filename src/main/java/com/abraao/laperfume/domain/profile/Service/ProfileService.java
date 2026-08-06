package com.abraao.laperfume.model.profile.Service;

import com.abraao.laperfume.infra.product.product.dto.response.ProductResDto;
import com.abraao.laperfume.infra.profile.dto.request.ProfileReqDto;
import com.abraao.laperfume.infra.profile.dto.response.ProfileResDto;
import com.abraao.laperfume.model.product.rating.Rating;
import com.abraao.laperfume.model.profile.Profile;

import java.util.List;

public interface ProfileService {


    //Profile

    Profile Create(ProfileReqDto profile);

    List<ProfileResDto> findAll();

    ProfileResDto findById(String id);

    ProfileResDto update(String id, ProfileReqDto profile);

    List<ProductResDto> findAllProductProfile(String id);

    void delete(String id);

    void addRating(String id, Rating rating);

    //Address

}
