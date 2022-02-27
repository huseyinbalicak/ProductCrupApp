package com.hsyn.balicak.productcrud.mapper;

import com.hsyn.balicak.productcrud.dto.ProductDto;
import com.hsyn.balicak.productcrud.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper implements Mapper<Product, ProductDto>{
    @Override
    public ProductDto toDto(Product product) {
        var productDto=new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setProductPrice(product.getProductPrice());
        productDto.setDescription(product.getDescription());
        return productDto;
    }

    @Override
    public Product toBusinessObject(ProductDto productDto) {
        var product=new Product();
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setDescription(productDto.getDescription());
        return product;
    }
}
