package com.abraao.laperfume.infra.product.controller;

import com.abraao.laperfume.infra.product.dto.request.FragranceReqDto;
import com.abraao.laperfume.infra.product.dto.response.FragranceResDto;
import com.abraao.laperfume.model.product.service.FragranceCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product/categories")
public class FragranceCategoryController {

    private final FragranceCategoryService fragranceCategoryService;

    public FragranceCategoryController(FragranceCategoryService fragranceCategoryService) {
        this.fragranceCategoryService = fragranceCategoryService;
    }

    @PostMapping()
    public FragranceResDto createCategory(FragranceReqDto fragranceReqDto) {
       return fragranceCategoryService.createCategory(fragranceReqDto);
    }

    @GetMapping("/{id}")
    public FragranceResDto findCategoryById(@PathVariable String id) {
        return fragranceCategoryService.findCategoryById(id);
    }

    @GetMapping()
    public List<FragranceResDto> findAllCategories(
            @RequestParam(required = false) String nameCategory
    ) {
        return fragranceCategoryService.findAllCategories(nameCategory);
    }

    @PutMapping("/{id}")
    public FragranceResDto updateCategory(String nameCategory, String id){
        return fragranceCategoryService.updateCategory(nameCategory, id);
    }

    @DeleteMapping
    public void deleteCategory(String id){
        fragranceCategoryService.deleteCategory(id);
    }
}
