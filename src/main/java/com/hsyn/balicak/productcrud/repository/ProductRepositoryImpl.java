package com.hsyn.balicak.productcrud.repository;

import com.hsyn.balicak.productcrud.exception.ProductRuntimeException;
import com.hsyn.balicak.productcrud.jpa.ProductPo;
import com.hsyn.balicak.productcrud.mapper.ProductMapper;
import com.hsyn.balicak.productcrud.model.PageableUtil;
import com.hsyn.balicak.productcrud.model.Paged;
import com.hsyn.balicak.productcrud.model.Paginated;
import com.hsyn.balicak.productcrud.model.Product;
import com.hsyn.balicak.productcrud.repository.spring.ProductSpringRepository;
import org.springframework.data.domain.Page;

import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository{

    private final ProductSpringRepository productSpringRepository;
    private final ProductMapper productMapper;

    public ProductRepositoryImpl(ProductSpringRepository productSpringRepository, ProductMapper productMapper) {
        this.productSpringRepository = productSpringRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Paged<Product> all(Paginated paginated) {
        Page<ProductPo> all = productSpringRepository.findAll(PageableUtil.getPageable(paginated));
        return productMapper.toPagedBusinessObject(all);
    }

    @Override
    public Product getOne(Long id) {
        Optional<ProductPo> optional = productSpringRepository.findById(id);
        ProductPo productPo;
        if (optional.isPresent()) {
            productPo = optional.get();
        } else {
            throw new ProductRuntimeException(" product not found for id :: " + id);
        }
        return  productMapper.toBusinessObject(productPo);

    }

    @Override
    public Product save(Product product) {
        ProductPo productPo;
        if (product.getId() == null) {
            productPo = productMapper.toPersistentCreateObject(product);

        } else {
            var existing = productSpringRepository.getOne(product.getId());
            productPo = productMapper.toPersistentUpdateObject(product, existing);
        }

        var savedProduct = productSpringRepository.save(productPo);

        return getOne(savedProduct.getId());
    }

    @Override
    public void deleteById(Long id) {
        productSpringRepository.deleteById(id);

    }
}