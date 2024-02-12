package com.example.cloudbees.product.cloudbeesproduct.service;

import com.example.cloudbees.product.cloudbeesproduct.dto.ProductDto;
import com.example.cloudbees.product.cloudbeesproduct.dto.ResponseDto;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductByProductId(Integer productId);

    String updateProduct(Integer productId, ProductDto productDto);

    String deleteProduct(Integer productId);
}
