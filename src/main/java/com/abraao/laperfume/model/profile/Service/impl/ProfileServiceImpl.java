package com.abraao.laperfume.model.profile.Service.impl;

import com.abraao.laperfume.infra.profile.repository.ProfileRepository;
import com.abraao.laperfume.model.profile.Profile;
import com.abraao.laperfume.model.profile.Service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }
}
