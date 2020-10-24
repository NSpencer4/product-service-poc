package com.productpickerservicepoc.service;

import com.productpickerservicepoc.dto.ProductRequest;
import com.productpickerservicepoc.mapper.ProductMapper;
import com.productpickerservicepoc.models.Product;
import com.productpickerservicepoc.repository.ProductRepository;
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
