package com.abraao.laperfume.infra.profile.repository;

import com.abraao.laperfume.model.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}
