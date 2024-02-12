package com.example.cloudbees.product.cloudbeesproduct.serviceimpl;

import com.example.cloudbees.product.cloudbeesproduct.Exception.ProductExceptionHandler;
import com.example.cloudbees.product.cloudbeesproduct.dao.ProductRepository;
import com.example.cloudbees.product.cloudbeesproduct.dto.ProductDto;
import com.example.cloudbees.product.cloudbeesproduct.dto.ResponseDto;
import com.example.cloudbees.product.cloudbeesproduct.model.Product;
import com.example.cloudbees.product.cloudbeesproduct.service.ProductTaxDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.cloudbees.product.cloudbeesproduct.serviceimpl.ProductServiceImpl.productModelToDto;

@Service
public class ProductTaxDiscountServiceImpl implements ProductTaxDiscountService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseDto<ProductDto> updateProductTax(Integer productId, Float tax, Float discount) {
        ProductDto productDto = new ProductDto();
        try {
            Product productRegisteredInDb = productRepository.findById(productId).get();
            Float price = productRegisteredInDb.getPrice();
            if (tax != null) {
                price = productRegisteredInDb.getPrice() + (productRegisteredInDb.getPrice() * tax/100);
            }else if (discount != null) {
                price = productRegisteredInDb.getPrice() - (productRegisteredInDb.getPrice() * discount / 100);
            } else if (tax != null && discount != null) {
                Float taxPrice = productRegisteredInDb.getPrice() + (productRegisteredInDb.getPrice() * tax/100);
                Float discountPrice = productRegisteredInDb.getPrice() - (productRegisteredInDb.getPrice() * discount / 100);
                price = taxPrice + discountPrice;
            }
            productRegisteredInDb.setPrice(price);
            productRepository.save(productRegisteredInDb);
            productDto = productModelToDto(productRegisteredInDb);
            return new ResponseDto<>("Product updated Successfully", productDto);
        }catch (Exception ex){
            throw new ProductExceptionHandler(ex.getMessage());
        }
    }

}
