package com.abraao.laperfume.model.product.service.impl;

import com.abraao.laperfume.infra.product.dto.request.FragranceReqDto;
import com.abraao.laperfume.infra.product.dto.response.FragranceResDto;
import com.abraao.laperfume.infra.product.repository.FragranceCategoryRepository;
import com.abraao.laperfume.model.product.FragranceCategory;
import com.abraao.laperfume.model.product.service.FragranceCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FragranceServiceImplService implements FragranceCategoryService {

    private final FragranceCategoryRepository fragranceCategoryRepository;
    private final ModelMapper mapper;


    public FragranceServiceImplService(FragranceCategoryRepository fragranceCategoryRepository, ModelMapper modelMapper) {
        this.fragranceCategoryRepository = fragranceCategoryRepository;
        this.mapper = modelMapper;
    }

    @Override
    public FragranceResDto createCategory(FragranceReqDto fragranceReqDto) {
        FragranceCategory fragranceCategory = FragranceCategory
                .builder()
                .name(fragranceReqDto.getName())
                .build();

        fragranceCategoryRepository.save(fragranceCategory);
        return mapper.map(fragranceCategory, FragranceResDto.class);
    }

    @Override
    public FragranceResDto findCategoryById(String id) {
        return mapper.map(fragranceCategoryRepository.findById(UUID.fromString(id))
                .orElseThrow(), FragranceResDto.class);
    }

    @Override
    public List<FragranceResDto> findAllCategories(String name) {
        return fragranceCategoryRepository.findAll()
                .stream()
                .map(fragrance -> mapper.map(fragrance, FragranceResDto.class))
                .toList();
    }

    @Override
    public void deleteCategory(String id) {
        fragranceCategoryRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public FragranceResDto updateCategory(String nameCategory, String id) {
        FragranceCategory fragranceCategory = fragranceCategoryRepository.findById(UUID.fromString(id))
                .orElseThrow();

        if (fragranceCategory.getName().equals(nameCategory) || fragranceCategory.getName().isBlank()) {
            return null;
        }

        fragranceCategory.changeName(nameCategory);
        return mapper.map(fragranceCategoryRepository.save(fragranceCategory), FragranceResDto.class);
    }
}
