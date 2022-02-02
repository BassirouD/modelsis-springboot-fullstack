package org.sid.modelsisspringbootfullstack.serices;

import org.sid.modelsisspringbootfullstack.dao.ProductRepo;
import org.sid.modelsisspringbootfullstack.dao.ProductTypeRepo;
import org.sid.modelsisspringbootfullstack.entities.ProdcutType;
import org.sid.modelsisspringbootfullstack.entities.Product;
import org.sid.modelsisspringbootfullstack.serices.iservices.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProduct {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    ProductTypeRepo productTypeRepo;

    @Override
    public Product save(Product product) {
        product.setCreated_date(new Date());
        return productRepo.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        product.setId(id);
        Product product1 = productRepo.findById(id).get();
        product1.setName(product.getName());
        product1.setCreated_date(product.getCreated_date());
        product1.setProdcutType(product.getProdcutType());
        return productRepo.save(product1);
    }

    @Override
    public Boolean delete(Long id) {
        productRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Product> lisProducts() {
        return productRepo.findAll();
    }
}
