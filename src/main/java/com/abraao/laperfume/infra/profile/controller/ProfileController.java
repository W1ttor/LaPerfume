package com.abraao.laperfume.infra.profile.controller;

import com.abraao.laperfume.infra.profile.dto.request.ProfileReqDto;
import com.abraao.laperfume.infra.profile.dto.response.ProfileResDto;
import com.abraao.laperfume.model.profile.Profile;
import com.abraao.laperfume.model.profile.Service.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public String saveProfile(ProfileReqDto profileReqDto) {
        Profile profile = profileService.Create(profileReqDto);
        return "Salvo com sucesso, Nome: " + profile.getName() + ", ID: " + profile.getId();
    }

    @GetMapping("/{id}")
    public ProfileResDto findById(@PathVariable String id) {
        return profileService.findById(id);
    }

    @GetMapping
    public List<ProfileResDto> getProfiles() {
        return  profileService.findAll();
    }

    @PatchMapping("/{id}")
    public ProfileResDto updateProfile(@PathVariable String id, @RequestBody ProfileReqDto profileReqDto) {
        return profileService.update(id,profileReqDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable String id) {
        profileService.delete(id);
    }
}
