package com.hsyn.balicak.productcrud.repository.spring;

import com.hsyn.balicak.productcrud.jpa.ProductPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpringRepository extends JpaRepository<ProductPo,Long> {

    ProductPo getOne(Long id);

}
