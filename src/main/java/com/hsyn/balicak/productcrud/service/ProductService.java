package com.hsyn.balicak.productcrud.service;

import com.hsyn.balicak.productcrud.model.Paged;
import com.hsyn.balicak.productcrud.model.Paginated;
import com.hsyn.balicak.productcrud.model.Product;
import com.hsyn.balicak.productcrud.repository.ProductRepository;

public class ProductService implements PagedService<Product> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Paged<Product> all(Paginated paginated) {
        return productRepository.all(paginated);
    }

    @Override
    public Product getOne(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
         productRepository.deleteById(id);
    }
}
