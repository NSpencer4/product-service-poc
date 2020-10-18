package com.productpickerservicepoc.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.productpickerservicepoc.models.Product;
import com.productpickerservicepoc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private ProductRepository productRepository;
    @Autowired
    public Mutation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Long id, String name,
                                 String shortdescription, String imageurl,
                                 Integer quantity, Double price) {
        Product product = new Product(id, name, shortdescription, imageurl, quantity, price);
        productRepository.save(product);
        return product;
    }
}
