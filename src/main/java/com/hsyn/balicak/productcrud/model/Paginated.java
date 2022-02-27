package com.hsyn.balicak.productcrud.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paginated {

    Integer pageNo = 0;
    Integer pageSize = 10;
    String sortField = "id";
    String sortDirection = "ASC";

    public String toString() {
        return "Paginated(pageNo=" + this.getPageNo() + ", pageSize=" + this.getPageSize() + ", sortField=" + this.getSortField() + ", sortDirection=" +
                this.getSortDirection() + ")";
    }
}
