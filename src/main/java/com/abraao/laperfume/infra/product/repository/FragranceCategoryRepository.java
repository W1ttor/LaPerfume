package com.abraao.laperfume.infra.product.repository;

import com.abraao.laperfume.model.product.FragranceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface FragranceCategoryRepository extends JpaRepository<FragranceCategory, UUID>, JpaSpecificationExecutor<FragranceCategory> {
}
