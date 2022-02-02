package org.sid.modelsisspringbootfullstack.serices.iservices;

import org.sid.modelsisspringbootfullstack.entities.ProdcutType;
import org.sid.modelsisspringbootfullstack.entities.Product;

import java.util.List;

public interface IProductType {
    ProdcutType save(ProdcutType prodcutType);
    ProdcutType update(Long id, ProdcutType prodcutType);
    Boolean delete(Long id);
    List<ProdcutType> liProdcutTypes();
}
