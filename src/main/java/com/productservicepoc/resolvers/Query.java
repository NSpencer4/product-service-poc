package com.productservicepoc.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.productservicepoc.models.Product;
import com.productservicepoc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private ProductRepository productRepository;

    @Autowired
    public Query(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Integer productId) {
        return this.productRepository.getOne(productId);
    }

    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
