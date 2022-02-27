package com.hsyn.balicak.productcrud.mapper;

import com.hsyn.balicak.productcrud.jpa.ProductPo;
import com.hsyn.balicak.productcrud.model.Product;

public class ProductMapper implements PagedMapper<ProductPo, Product>{


    @Override
    public Product toBusinessObject(ProductPo productPo) {
        var product = new Product();
        product.setProductName(productPo.getProductName());
        product.setProductPrice(productPo.getProductPrice());
        product.setDescription(productPo.getDescription());
        return product;
    }

    @Override
    public ProductPo toPersistentCreateObject(Product product) {
       return getProductPo(product, new ProductPo());
    }

    @Override
    public ProductPo toPersistentUpdateObject(Product product, ProductPo productPo) {
        return getProductPo(product,productPo);
    }


    private ProductPo getProductPo(Product product, ProductPo productPo) {
        productPo.setProductName(product.getProductName());
        productPo.setProductPrice(product.getProductPrice());
        productPo.setDescription(product.getDescription());
        return productPo;
    }


}
