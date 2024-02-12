package com.example.cloudbees.product.cloudbeesproduct;


import com.example.cloudbees.product.cloudbeesproduct.dao.ProductRepository;
import com.example.cloudbees.product.cloudbeesproduct.model.Product;
import com.example.cloudbees.product.cloudbeesproduct.serviceimpl.ProductTaxDiscountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductTaxDiscountServiceTest {

    @InjectMocks
    ProductTaxDiscountServiceImpl productTaxDiscountService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void updateProductTaxTest(){
        Product inputProduct = new Product();
        inputProduct.setProductId(1);
        inputProduct.setName("P1");
        inputProduct.setDescription("Test Product P1");
        inputProduct.setPrice(29.00F);
        inputProduct.setQuantityAvailable(4);
        Float tax = 30.0F;
        Float discount = 29.0F;
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(inputProduct));
        String message = productTaxDiscountService.updateProductTax(inputProduct.getProductId(), tax, discount).getMessage();
        Assertions.assertEquals(message, "Product updated Successfully");
    }
}
