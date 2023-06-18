package com.totem.food.application.usecases.product;

import com.totem.food.application.ports.in.dtos.product.ProductDto;
import com.totem.food.application.ports.in.mappers.product.IProductMapper;
import com.totem.food.application.ports.out.persistence.commons.ISearchUniqueRepositoryPort;
import com.totem.food.application.usecases.commons.ISearchUniqueUseCase;
import com.totem.food.domain.product.ProductDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchUniqueProductUseCase implements ISearchUniqueUseCase<String, ProductDto> {

    private final IProductMapper iProductMapper;
    private final ISearchUniqueRepositoryPort<ProductDomain> iSearchUniqueRepositoryPort;

    @Override
    public ProductDto item(String id) {
        final var productDomain = iSearchUniqueRepositoryPort.findById(id);
        return iProductMapper.toDto(productDomain);
    }
}