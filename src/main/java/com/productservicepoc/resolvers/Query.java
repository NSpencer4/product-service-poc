package com.productservicepoc.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.productservicepoc.models.Product;
import com.productservicepoc.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private final ProductServiceImpl productService;

    @Autowired
    public Query(ProductServiceImpl productService) {
        this.productService = productService;
    }

    public List<Product> products() {
        return this.productService.getAll();
    }

    public Product getProductById(Integer productId) { return this.productService.getById(productId);}
}
