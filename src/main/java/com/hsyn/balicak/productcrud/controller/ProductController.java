package com.hsyn.balicak.productcrud.controller;

import com.hsyn.balicak.productcrud.dto.ProductDto;
import com.hsyn.balicak.productcrud.mapper.Mapper;
import com.hsyn.balicak.productcrud.model.PagedResponse;
import com.hsyn.balicak.productcrud.model.Paginated;
import com.hsyn.balicak.productcrud.model.Product;
import com.hsyn.balicak.productcrud.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final Mapper<Product, ProductDto> mapper;

    @GetMapping("")
    public PagedResponse<ProductDto> all(Paginated paginated) {

            var productPaged = productService.all(paginated);
            return mapper.toPagedResponse(productPaged);
    }


    @GetMapping("/{id}")
    public ProductDto one(@PathVariable Long id) {

            var one = productService.getOne(id);
            return mapper.toDto(one);

    }

    @PostMapping("")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {

            var created = productService.create(mapper.toBusinessObject(dto));
            return new ResponseEntity<>(mapper.toDto(created), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ProductDto update(@RequestBody ProductDto dto, @PathVariable Long id) {

            var create = productService.update(id, mapper.toBusinessObject(dto));
            return mapper.toDto(create);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable Long id) {

            productService.deleteById(id);
            return ResponseEntity.noContent().build();

    }
}
