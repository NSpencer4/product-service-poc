package com.productpickerservicepoc.mapper;

import com.productpickerservicepoc.dto.ProductDto;
import com.productpickerservicepoc.models.Product;

public class ProductMapper {
    public Product map(ProductDto productDto) {
        return new Product(
                productDto.id,
                productDto.name,
                productDto.manufacturerName,
                productDto.category,
                productDto.itemNumber,
                productDto.description,
                productDto.imageUrl,
                productDto.createdAt
                );
    }
}
