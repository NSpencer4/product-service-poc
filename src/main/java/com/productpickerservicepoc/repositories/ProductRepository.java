package com.productpickerservicepoc.repositories;

import com.productpickerservicepoc.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
