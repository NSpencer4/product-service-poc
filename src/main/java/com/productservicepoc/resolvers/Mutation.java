package com.productservicepoc.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.productservicepoc.models.Product;
import com.productservicepoc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private ProductRepository productRepository;
    @Autowired
    public Mutation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Integer product_id, String name,
                                 String manufacturerName, String category,
                                 String itemNumber, String description,
                                 String image_url, String created_at) {
        Product product = new Product(product_id, name, manufacturerName, category, itemNumber, description, image_url, created_at);
        productRepository.save(product);
        return product;
    }
}
