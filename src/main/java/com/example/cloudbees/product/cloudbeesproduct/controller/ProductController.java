package com.example.cloudbees.product.cloudbeesproduct.controller;


import com.example.cloudbees.product.cloudbeesproduct.dto.ProductDto;
import com.example.cloudbees.product.cloudbeesproduct.dto.ResponseDto;
import com.example.cloudbees.product.cloudbeesproduct.service.ProductService;
import com.example.cloudbees.product.cloudbeesproduct.service.ProductTaxDiscountService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTaxDiscountService productTaxService;


    @PostMapping(path = "/createProduct", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping(path = "/getProductByProductId/{productId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProductByProductId(@PathVariable Integer productId) {
        return productService.getProductByProductId(productId);
    }

    @PutMapping(path = "/updateProduct/{productId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String updateProduct(@PathVariable Integer productId, @RequestBody ProductDto productDto) {
        return productService.updateProduct(productId, productDto);
    }

    @DeleteMapping(path = "/deleteProduct/{productId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }

    @PutMapping(path = "/updateProductTax/{productId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<ProductDto> updateProductTax(@PathVariable Integer productId, @Nullable @RequestParam Float tax, @Nullable @RequestParam Float discount) {
        return productTaxService.updateProductTax(productId, tax, discount);
    }
}
