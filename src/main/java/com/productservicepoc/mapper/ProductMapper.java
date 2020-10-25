package com.productservicepoc.mapper;

import com.productservicepoc.dto.ProductRequest;
import com.productservicepoc.models.Product;

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
