package com.productservicepoc.service;

import com.productservicepoc.constants.Constants;
import com.productservicepoc.dto.ProductDto;
import com.productservicepoc.exception.NotFoundException;
import com.productservicepoc.mapper.ProductMapper;
import com.productservicepoc.models.Product;
import com.productservicepoc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Service
public class ProductServiceImpl {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productMapper = new ProductMapper();
    }

    @Transactional()
    public ResponseEntity<Void> create(ProductDto productDto) {
        Product product = productMapper.mapProductDtoToProduct(productDto);
        productRepository.save(product);
        return new ResponseEntity<>(CREATED);
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return new ArrayList<>(productRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Product getById(Integer id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.PRODUCT_NOT_FOUND_ERROR_MESSAGE));
    }
}
