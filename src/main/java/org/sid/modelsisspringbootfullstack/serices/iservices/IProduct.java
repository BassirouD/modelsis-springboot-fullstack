package org.sid.modelsisspringbootfullstack.serices.iservices;

import org.sid.modelsisspringbootfullstack.entities.Product;

import java.util.List;

public interface IProduct {
    Product save(Product product);
    Product update(Long id, Product product);
    Boolean delete(Long id);
    List<Product> lisProducts();
}
