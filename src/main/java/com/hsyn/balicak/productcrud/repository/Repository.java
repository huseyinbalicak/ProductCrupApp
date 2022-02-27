package com.hsyn.balicak.productcrud.repository;

public interface Repository<T> {
    T getOne(Long id);

    T save(T data);

    void deleteById(Long id);
}
