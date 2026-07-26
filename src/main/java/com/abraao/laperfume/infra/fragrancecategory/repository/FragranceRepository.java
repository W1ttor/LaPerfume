package com.abraao.laperfume.infra.fragrancecategory.repository;

import com.abraao.laperfume.model.product.FragranceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FragranceRepository extends JpaRepository<FragranceCategory, UUID> {
}
