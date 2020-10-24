package com.productpickerservicepoc.mapper;

import com.productpickerservicepoc.dto.ProductRequest;
import com.productpickerservicepoc.models.Product;

public class ProductMapper {
    public Product map(ProductRequest productRequestDto) {
        return new Product(
                productRequestDto.getId(),
                productRequestDto.getName(),
                productRequestDto.getManufacturerName(),
                productRequestDto.getCategory(),
                productRequestDto.getItemNumber(),
                productRequestDto.getDescription(),
                productRequestDto.getImageUrl(),
                productRequestDto.getCreatedAt()
                );
    }
}
