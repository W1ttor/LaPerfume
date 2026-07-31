package com.abraao.laperfume.model.product.category.service;

import com.abraao.laperfume.infra.product.category.dto.request.FragranceReqDto;
import com.abraao.laperfume.infra.product.category.dto.response.FragranceResDto;

import java.util.List;

public interface FragranceCategoryService {
    FragranceResDto createCategory(FragranceReqDto fragranceReqDto);
    FragranceResDto findCategoryById(String id);
    List<FragranceResDto> findAllCategories(String name);
    void deleteCategory(String id);
    FragranceResDto updateCategory(String nameCategory, String id);
}
