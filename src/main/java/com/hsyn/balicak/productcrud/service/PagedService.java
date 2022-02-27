package com.hsyn.balicak.productcrud.service;

import com.hsyn.balicak.productcrud.model.Paged;
import com.hsyn.balicak.productcrud.model.Paginated;

public interface PagedService<T> {

    Paged<T> all(Paginated paginated);

    T getOne(Long id);

    T create(T businessObject);

    T update(Long id, T businessObject);

    void deleteById(Long id);
}