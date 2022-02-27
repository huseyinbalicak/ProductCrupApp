package com.hsyn.balicak.productcrud.mapper;

import com.hsyn.balicak.productcrud.dto.IdentifiableDto;
import com.hsyn.balicak.productcrud.model.Paged;
import com.hsyn.balicak.productcrud.model.PagedResponse;

import java.util.stream.Collectors;

public interface Mapper<T, D extends IdentifiableDto> {

    default PagedResponse<D> toPagedResponse(Paged<T> paged) {
        PagedResponse<D> response = new PagedResponse<>();
        response.setData(paged.getData().stream().map(this::toDto).collect(Collectors.toList()));
        response.setNumber(paged.getNumber());
        response.setSize(paged.getSize());
        response.setTotalPages(paged.getTotalPages());
        response.setTotalElements(paged.getTotalElements());
        return response;
    }

    D toDto(T businessObject);

    T toBusinessObject(D dtoObject);
}
