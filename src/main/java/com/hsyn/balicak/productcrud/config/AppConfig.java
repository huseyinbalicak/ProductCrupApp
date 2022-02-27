package com.hsyn.balicak.productcrud.config;

import com.hsyn.balicak.productcrud.mapper.ProductMapper;
import com.hsyn.balicak.productcrud.repository.ProductRepository;
import com.hsyn.balicak.productcrud.repository.ProductRepositoryImpl;
import com.hsyn.balicak.productcrud.repository.spring.ProductSpringRepository;
import com.hsyn.balicak.productcrud.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper();
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

    @Bean
    public ProductRepository productRepository(
            ProductSpringRepository productSpringRepository, ProductMapper productMapper) {
        return new ProductRepositoryImpl(productSpringRepository,productMapper);
    }


}