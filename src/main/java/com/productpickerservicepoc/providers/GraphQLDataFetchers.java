package com.productpickerservicepoc.providers;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {
    private static List<Map<String, String>> products = Arrays.asList(
            ImmutableMap.<String, String>builder()
                    .put("id", "id")
                    .put("name", "name")
                    .put("shortdescription", "shortdescription")
                    .put("imageurl", "imageurl")
                    .put("quantity", "quantity")
                    .put("price", "price")
            .build());
    public DataFetcher getProductById() {
        return dataFetchingEnvironment -> {
            String productId = dataFetchingEnvironment.getArgument("id");
            return products
                    .stream()
                    .filter(product -> product.get("id").equals(productId))
                    .findFirst()
                    .orElse(null);
        };
    }
    public DataFetcher findAllProducts() {
        return dataFetchingEnvironment -> products
                .stream()
                .findAny()
                .orElse(null);
    }
}
