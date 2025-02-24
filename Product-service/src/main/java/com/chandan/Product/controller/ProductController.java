package com.chandan.Product.controller;

import com.chandan.Product.dto.ProductRequest;
import com.chandan.Product.model.Product;
import com.chandan.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService; //@RequiredArgsConstructor


    //create product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest){
         return productService.createProduct(productRequest);
    }

}
