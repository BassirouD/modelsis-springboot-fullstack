package org.sid.modelsisspringbootfullstack.Controllers;

import org.sid.modelsisspringbootfullstack.entities.ProdcutType;
import org.sid.modelsisspringbootfullstack.entities.Product;
import org.sid.modelsisspringbootfullstack.serices.iservices.IProduct;
import org.sid.modelsisspringbootfullstack.serices.iservices.IProductType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/productType")

public class ProductTypeController {

    Logger logger = LoggerFactory.getLogger(ProductTypeController.class);

    @Autowired
    private IProductType productTypeService;

    @PostMapping(value = "/save")
    ProdcutType saveProductType(@RequestBody ProdcutType prodcutType){
        logger.info("Insertion produitType ok: " + prodcutType);
        return productTypeService.save(prodcutType);
    }

    @PutMapping(value = "/update/{id}")
    ProdcutType updateProductType(@PathVariable Long id, @RequestBody ProdcutType prodcutType){
        return productTypeService.update(id, prodcutType);
    }

    @DeleteMapping(value = "/delete/{id}")
    Boolean deleteProductType(@PathVariable Long id){
        return productTypeService.delete(id);
    }

    @GetMapping(value = "/getAll")
    List <ProdcutType> getALlProductType(){
        return productTypeService.liProdcutTypes();
    }

}
