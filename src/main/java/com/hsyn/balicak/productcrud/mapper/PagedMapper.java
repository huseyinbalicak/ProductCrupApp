package com.hsyn.balicak.productcrud.mapper;


import com.hsyn.balicak.productcrud.model.Paged;
import org.springframework.data.domain.Page;
import java.util.stream.Collectors;

public interface PagedMapper<P, T> {

    default Paged<T> toPagedBusinessObject(Page<P> page) {
        var data = page.get().map(this::toBusinessObject).collect(Collectors.toList());

        var paged = new Paged<T>();
        paged.setData(data);
        paged.setNumber(page.getNumber());
        paged.setSize(page.getSize());
        paged.setTotalPages(page.getTotalPages());
        paged.setTotalElements(page.getTotalElements());
        return paged;
    }

    T toBusinessObject(P persistentObject);

    P toPersistentCreateObject(T businessObject);

    P toPersistentUpdateObject(T businessObject, P persistentObject);

}
