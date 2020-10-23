package com.productpickerservicepoc.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.productpickerservicepoc.models.Product;
import com.productpickerservicepoc.repositories.ProductRepository;
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
