package com.microservice.product.service.service;

import com.microservice.product.service.dto.ProductRequest;
import com.microservice.product.service.dto.ProductResponse;

import java.util.List;

public interface IProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
