package com.productservicepoc.mapper;

import com.productservicepoc.dto.ProductDto;
import com.productservicepoc.models.Product;

public class ProductMapper {
    public Product mapProductDtoToProduct(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getManufacturerName(),
                productDto.getCategory(),
                productDto.getItemNumber(),
                productDto.getDescription(),
                productDto.getImageUrl(),
                productDto.getCreatedAt()
        );
    }
    public ProductDto mapProductToProductDto(Product product) {
        return new ProductDto(
                product.getProduct_id(),
                product.getName(),
                product.getManufacturer_name(),
                product.getCategory(),
                product.getItem_number(),
                product.getDescription(),
                product.getImage_url(),
                product.getCreated_at()
        );
    }
}
