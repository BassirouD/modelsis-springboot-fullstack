package org.sid.modelsisspringbootfullstack.Controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.modelsisspringbootfullstack.dao.ProductRepo;
import org.sid.modelsisspringbootfullstack.dao.ProductTypeRepo;
import org.sid.modelsisspringbootfullstack.entities.ProdcutType;
import org.sid.modelsisspringbootfullstack.entities.Product;
import org.sid.modelsisspringbootfullstack.serices.iservices.IProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")

public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProduct productService;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductTypeRepo productTypeRepo;

    @PostMapping(value = "/save")
    Product saveProduct(@RequestBody ProductForm product){
        System.out.println("*********************" + product);
//        return productService.save(product);
        ProdcutType prodcutType = productTypeRepo.findById(product.getIdTypeProduct()).get();
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setProdcutType(prodcutType);
        product1.setCreated_date(new Date());
        logger.info("Insertion produit: " + product1);
        return productRepo.save(product1);
    }

    @PutMapping(value = "/update/{id}")
    Product updateProduct(@PathVariable Long id, @RequestBody ProductForm product){
//        product.setId(id);
//        System.out.println("************: getId "+product.getId());
//        System.out.println("****************"+id);
        ProdcutType prodcutType = productTypeRepo.findById(product.getIdTypeProduct()).get();
        Product product1 = productRepo.findById(id).get();
        product1.setName(product.getName());
        product1.setProdcutType(prodcutType);
        logger.info("Update produit ok: " + product1);
        return productRepo.save(product1);
    }

    @DeleteMapping(value = "/delete/{id}")
    Boolean deleteProduct(@PathVariable Long id){
        return productService.delete(id);
    }

    @GetMapping(value = "/getAll")
    List<Product> getALlProduct(){
        return productService.lisProducts();
    }
}

@Data
@AllArgsConstructor @NoArgsConstructor
class ProductForm{
    private Long id;
    private String name;
    private Long idTypeProduct;
}
