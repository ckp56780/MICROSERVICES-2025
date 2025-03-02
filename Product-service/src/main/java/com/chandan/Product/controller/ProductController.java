package com.chandan.Product.controller;

import com.chandan.Product.dto.ProductRequest;
import com.chandan.Product.dto.ProductResponse;
import com.chandan.Product.model.Product;
import com.chandan.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService; //@RequiredArgsConstructor


    //create product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
         return productService.createProduct(productRequest);
    }

    //get all products
    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProduct();
    }

}
