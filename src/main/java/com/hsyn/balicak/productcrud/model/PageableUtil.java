package com.hsyn.balicak.productcrud.model;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableUtil {

    private PageableUtil() {
        // default constructor
    }

    public static Pageable getPageable(Paginated paginated) {
        var sort = Sort.by(paginated.getSortField());
        sort = paginated.getSortDirection().equalsIgnoreCase(Sort.Direction.ASC.name()) ? sort.ascending() : sort.descending();
        return PageRequest.of(paginated.getPageNo(), paginated.getPageSize(), sort);
    }

}

