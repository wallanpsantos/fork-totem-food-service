package com.totem.food.application.usecases.category;

import com.totem.food.application.ports.in.dtos.category.CategoryDto;
import com.totem.food.application.ports.in.dtos.category.CategoryFilterDto;
import com.totem.food.application.ports.in.mappers.category.ICategoryMapper;
import com.totem.food.application.ports.out.persistence.commons.ISearchRepositoryPort;
import com.totem.food.application.usecases.commons.ISearchUniqueUseCase;
import com.totem.food.domain.category.CategoryDomain;
import com.totem.food.domain.exceptions.ResourceNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchUniqueCategoryUseCase implements ISearchUniqueUseCase<String, CategoryDto> {

    private final ICategoryMapper iCategoryMapper;
    private final ISearchRepositoryPort<CategoryFilterDto, CategoryDomain> iSearchRepositoryPort;

    @Override
    public CategoryDto item(String id) {
        final var categoryDomain = iSearchRepositoryPort.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound(SearchUniqueCategoryUseCase.class, "Error searching item by identifier"));

        return iCategoryMapper.toDto(categoryDomain);
    }

}
