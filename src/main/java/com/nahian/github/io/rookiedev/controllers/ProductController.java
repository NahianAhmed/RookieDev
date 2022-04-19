package com.nahian.github.io.rookiedev.controllers;

import com.nahian.github.io.rookiedev.models.Product;
import com.nahian.github.io.rookiedev.repositorys.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping("/indexing/product")
    public Product indexProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
