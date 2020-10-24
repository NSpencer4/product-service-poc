package com.productpickerservicepoc.controller;

import com.productpickerservicepoc.dto.ProductDto;
import com.productpickerservicepoc.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody ProductDto productDto) {
        productService.create(productDto);
        return new ResponseEntity<>(CREATED);
    }
}
