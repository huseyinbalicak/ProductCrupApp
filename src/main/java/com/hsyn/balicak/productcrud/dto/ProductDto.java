package com.hsyn.balicak.productcrud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto extends IdentifiableDto {

    private String productName;
    private Double productPrice;
    private String description;

}
