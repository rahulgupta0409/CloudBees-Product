package com.example.cloudbees.product.cloudbeesproduct;


import com.example.cloudbees.product.cloudbeesproduct.dao.ProductRepository;
import com.example.cloudbees.product.cloudbeesproduct.dto.ProductDto;
import com.example.cloudbees.product.cloudbeesproduct.model.Product;
import com.example.cloudbees.product.cloudbeesproduct.serviceimpl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void createProduct(){
        ProductDto inputProduct = new ProductDto();
        inputProduct.setName("P1");
        inputProduct.setDescription("Test Product P1");
        inputProduct.setPrice(29.00F);
        inputProduct.setQuantityAvailable(4);
        ProductDto testProduct = productService.createProduct(inputProduct);
        Assertions.assertEquals(testProduct.getName(), inputProduct.getName());
    }

    @Test
    public void getProductByProductId(){
        Product inputProduct = new Product();
        inputProduct.setProductId(1);
        inputProduct.setName("P2");
        inputProduct.setDescription("Test Product P2");
        inputProduct.setPrice(30.01F);
        inputProduct.setQuantityAvailable(8);
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(inputProduct));
        ProductDto product = productService.getProductByProductId(1);
        Assertions.assertEquals(product.getProductId(), inputProduct.getProductId());
    }

    @Test
    public void updateProduct(){
        Product inputProduct = new Product();
        inputProduct.setProductId(1);
        inputProduct.setName("P3");
        inputProduct.setDescription("Test Product P3");
        inputProduct.setPrice(300.01F);
        inputProduct.setQuantityAvailable(8);
        ProductDto inputProductDto = new ProductDto();
        inputProductDto.setName("P4");
        inputProductDto.setDescription("Test Product P4");
        inputProductDto.setPrice(133.01F);
        inputProductDto.setQuantityAvailable(8);
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(inputProduct));
        String message = productService.updateProduct(1 , inputProductDto);
        Assertions.assertEquals(message, "Product updated Successfully");
    }

    @Test
    public void deleteProduct(){
        Product inputProduct = new Product();
        inputProduct.setProductId(1);
        inputProduct.setName("P3");
        inputProduct.setDescription("Test Product P3");
        inputProduct.setPrice(300.01F);
        inputProduct.setQuantityAvailable(8);
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(inputProduct));
        String message = productService.deleteProduct(inputProduct.getProductId());
        Assertions.assertEquals(message, "Product deleted Successfully");
    }
}
