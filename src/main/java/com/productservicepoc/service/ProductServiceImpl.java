package com.productservicepoc.service;

import com.productservicepoc.dto.ProductRequest;
import com.productservicepoc.mapper.ProductMapper;
import com.productservicepoc.models.Product;
import com.productservicepoc.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public void create(ProductRequest productRequestDto) {
        Product product = productMapper.map(productRequestDto);
        productRepository.save(product);
    }
}
