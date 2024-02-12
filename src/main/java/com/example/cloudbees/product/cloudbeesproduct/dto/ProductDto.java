package com.example.cloudbees.product.cloudbeesproduct.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    private Integer productId;

    private String name;

    private String description;

    private Float price;

    private Integer quantityAvailable;
}
