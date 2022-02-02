package org.sid.modelsisspringbootfullstack.serices;

import org.sid.modelsisspringbootfullstack.dao.ProductTypeRepo;
import org.sid.modelsisspringbootfullstack.entities.ProdcutType;
import org.sid.modelsisspringbootfullstack.entities.Product;
import org.sid.modelsisspringbootfullstack.serices.iservices.IProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductTypeService implements IProductType {

    @Autowired
    private ProductTypeRepo productTypeRepo;

    @Override
    public ProdcutType save(ProdcutType prodcutType) {
        return productTypeRepo.save(prodcutType);
    }

    @Override
    public ProdcutType update(Long id, ProdcutType prodcutType) {
        prodcutType.setId(id);
        ProdcutType prodcutType1 = productTypeRepo.findById(id).get();
        prodcutType1.setName(prodcutType.getName());
        return productTypeRepo.save(prodcutType1);
    }

    @Override
    public Boolean delete(Long id) {
        productTypeRepo.deleteById(id);
        return true;
    }

    @Override
    public List<ProdcutType> liProdcutTypes() {
        return productTypeRepo.findAll();
    }
}
