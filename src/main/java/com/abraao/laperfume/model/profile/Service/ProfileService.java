package com.abraao.laperfume.model.profile.Service;

import com.abraao.laperfume.infra.profile.dto.request.ProfileReqDto;
import com.abraao.laperfume.infra.profile.dto.response.ProfileResDto;
import com.abraao.laperfume.model.profile.Profile;

import java.util.List;
import java.util.UUID;

public interface ProfileService {


    //Profile

    Profile Create(ProfileReqDto profile);

    List<ProfileResDto> findAll();

    ProfileResDto findById(String id);

    ProfileResDto update(String id, ProfileReqDto profile);

    void delete(String id);

    //Address

}
