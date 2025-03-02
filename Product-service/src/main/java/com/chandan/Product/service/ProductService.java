package com.chandan.Product.service;

import com.chandan.Product.dto.ProductRequest;
import com.chandan.Product.dto.ProductResponse;
import com.chandan.Product.model.Product;
import com.chandan.Product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private ProductRepository productRepository;     // using @RequiredArgsConstructor


    public  ProductResponse createProduct(ProductRequest productRequest){
        Product product=Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price()).build();
        productRepository.save(product);
        log.info("product created successfully");
        return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice());
    }

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream().map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice())).toList();

    }
}
