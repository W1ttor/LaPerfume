package com.abraao.laperfume.model.profile.Service.impl;

import com.abraao.laperfume.infra.product.product.dto.response.ProductResDto;
import com.abraao.laperfume.infra.profile.dto.request.ProfileReqDto;
import com.abraao.laperfume.infra.profile.dto.response.ProfileResDto;
import com.abraao.laperfume.infra.profile.repository.ProfileRepository;
import com.abraao.laperfume.model.profile.Profile;
import com.abraao.laperfume.model.profile.Service.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    private final ModelMapper model;

    public ProfileServiceImpl(ProfileRepository profileRepository,  ModelMapper model) {
        this.profileRepository = profileRepository;
        this.model = model;
    }

    @Override
    public List<ProfileResDto> findAll() {
        return profileRepository.findAll()
                .stream()
                .map(profile -> this.model.map(profile, ProfileResDto.class))
                .toList();
    }


    @Override
    public Profile Create(ProfileReqDto profileReqDto) {

        Profile profile = Profile.builder()
                .name(profileReqDto.getName())
                .email(profileReqDto.getEmail())
                .cpf(profileReqDto.getCpf())
                .birthYear(profileReqDto.getBirthYear())
                .inactive(false)
                .deleted(false)
                .build();
        return profileRepository.save(profile);
    }

    @Override
    public ProfileResDto findById(String id) {
        return model.map(profileRepository.findById(id), ProfileResDto.class);
    }

    @Override
    public ProfileResDto update(String id, ProfileReqDto profileReqDto) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow();

        profile.setName(profileReqDto.getName());
        profile.setEmail(profileReqDto.getEmail());
        profile.setCpf(profileReqDto.getCpf());
        profile.setBirthYear(profileReqDto.getBirthYear());

        profileRepository.save(profile);

        return model.map(profile, ProfileResDto.class);
    }

    @Override
    public List<ProductResDto> findAllProductProfile(String id) {

        Profile profile = profileRepository.findById(id)
                .orElseThrow();

        return profile.getProducts()
                .stream()
                .map(product -> model.map(product, ProductResDto.class))
                .toList();

    }

    @Override
    public void delete(String id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow();
        profile.setDeleted(true);
        profileRepository.save(profile);
    }
}
