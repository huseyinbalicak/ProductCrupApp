package com.hsyn.balicak.productcrud.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long id;
    private String productName;
    private Double productPrice;
    private String description;


}
