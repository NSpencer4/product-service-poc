package com.productpickerservicepoc.service;

import com.productpickerservicepoc.dto.ProductDto;
import com.productpickerservicepoc.mapper.ProductMapper;
import com.productpickerservicepoc.models.Product;
import com.productpickerservicepoc.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public void create(ProductDto productDto) {
        Product product = productMapper.map(productDto);
        productRepository.save(product);
    }
}
