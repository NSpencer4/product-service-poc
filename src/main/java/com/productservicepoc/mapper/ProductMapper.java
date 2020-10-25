package com.productservicepoc.mapper;

import com.productservicepoc.dto.ProductDto;
import com.productservicepoc.models.Product;

public class ProductMapper {
    public Product map(ProductDto productDtoDto) {
        return new Product(
                productDtoDto.getId(),
                productDtoDto.getName(),
                productDtoDto.getManufacturerName(),
                productDtoDto.getCategory(),
                productDtoDto.getItemNumber(),
                productDtoDto.getDescription(),
                productDtoDto.getImageUrl(),
                productDtoDto.getCreatedAt()
                );
    }
}
