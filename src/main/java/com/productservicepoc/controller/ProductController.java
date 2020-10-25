package com.productservicepoc.controller;

import com.productservicepoc.dto.ProductRequest;
import com.productservicepoc.service.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody ProductRequest productRequestDto) {
        productServiceImpl.create(productRequestDto);
        return new ResponseEntity<>(CREATED);
    }

    //TODO: get by id
    //TODO: get all
    //TODO: Update
    //TODO: Delete
}
