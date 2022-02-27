package com.hsyn.balicak.productcrud.repository;

import com.hsyn.balicak.productcrud.model.Paged;
import com.hsyn.balicak.productcrud.model.Paginated;

public interface PaginatedRepository<T> extends Repository<T> {

    Paged<T> all(Paginated paginated);

}