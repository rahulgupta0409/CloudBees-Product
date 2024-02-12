package com.example.cloudbees.product.cloudbeesproduct.service;

import com.example.cloudbees.product.cloudbeesproduct.dto.ProductDto;
import com.example.cloudbees.product.cloudbeesproduct.dto.ResponseDto;

public interface ProductTaxDiscountService {

    public ResponseDto<ProductDto> updateProductTax(Integer productId, Float tax, Float discount);

}
