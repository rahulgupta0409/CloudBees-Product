package com.example.cloudbees.product.cloudbeesproduct.serviceimpl;

import com.example.cloudbees.product.cloudbeesproduct.Exception.ProductExceptionHandler;
import com.example.cloudbees.product.cloudbeesproduct.dao.ProductRepository;
import com.example.cloudbees.product.cloudbeesproduct.dto.ProductDto;
import com.example.cloudbees.product.cloudbeesproduct.model.Product;
import com.example.cloudbees.product.cloudbeesproduct.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        try {
            Product product = Product.builder()
                    .name(productDto.getName())
                    .price(productDto.getPrice())
                    .description(productDto.getDescription())
                    .quantityAvailable(productDto.getQuantityAvailable())
                    .build();
            productRepository.save(product);
            productDto.setProductId(product.getProductId());
            return productDto;
        }catch (Exception ex){
            throw new ProductExceptionHandler(ex.getMessage());
        }
    }

    @Override
    public ProductDto getProductByProductId(Integer productId) {
        try{
            Product product = productRepository.findById(productId).get();
            ProductDto productDto = productModelToDto(product);
            return productDto;
        }catch (Exception ex){
            throw new ProductExceptionHandler("Error : No Product found.");
        }
    }

    @Override
    public String updateProduct(Integer productId, ProductDto productDto) {
        try {
            if(productRepository.findById(productId).isPresent()) {
                Product productRegisteredInDb = productRepository.findById(productId).get();
                if(productDto.getName() != null){
                    productRegisteredInDb.setName(productDto.getName());
                }
                if(productDto.getDescription() != null){
                    productRegisteredInDb.setDescription(productDto.getDescription());
                }
                if(productDto.getPrice() != null){
                    productRegisteredInDb.setPrice(productDto.getPrice());
                }
                if(productDto.getQuantityAvailable() != null){
                    productRegisteredInDb.setQuantityAvailable(productDto.getQuantityAvailable());
                }
                productRepository.save(productRegisteredInDb);
            }
            return "Product updated Successfully";
        }catch (Exception ex){
            throw new ProductExceptionHandler(ex.getMessage());
        }
    }


    @Override
    public String deleteProduct(Integer productId) {
        try{
            Product product = productRepository.findById(productId).get();
            productRepository.delete(product);
            return "Product deleted Successfully";
        }catch (Exception ex){
            throw new ProductExceptionHandler(ex.getMessage());
        }
    }

    public static ProductDto productModelToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantityAvailable(product.getQuantityAvailable());
        return productDto;
    }
}
