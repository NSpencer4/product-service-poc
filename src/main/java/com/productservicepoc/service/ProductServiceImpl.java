package com.productservicepoc.service;

import com.productservicepoc.dto.ProductDto;
import com.productservicepoc.mapper.ProductMapper;
import com.productservicepoc.models.Product;
import com.productservicepoc.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public void create(ProductDto productDtoDto) {
        Product product = productMapper.map(productDtoDto);
        productRepository.save(product);
    }
}
