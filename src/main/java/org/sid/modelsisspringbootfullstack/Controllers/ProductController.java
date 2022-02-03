package org.sid.modelsisspringbootfullstack.Controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.modelsisspringbootfullstack.Outils.Response;
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
    public Response<?> saveProduct(@RequestBody ProductForm product) {
        try {
            ProdcutType prodcutType = productTypeRepo.findById(product.getIdTypeProduct()).get();
            Product product1 = new Product();
            product1.setName(product.getName());
            product1.setProdcutType(prodcutType);
            product1.setCreated_date(new Date());
            logger.info("Insertion produit: ");
            productRepo.save(product1);
            return product1 == null ? Response
                    .badRequest()
                    .setErrors("Error 400") : Response
                    .internalServerError()
                    .setErrors("Error 500")
                    .notFound()
                    .setErrors("Error 404")
                    .ok()
                    .setData(product1)
                    .setMessage("Produit enregistré avec success");
        } catch (Exception e) {
            e.printStackTrace();
            return Response
                    .exception()
                    .setErrors(e.getMessage());
        }
    }

    @PutMapping(value = "/update/{id}")
    public Response<?> updateProduct(@PathVariable Long id, @RequestBody ProductForm product) {
//        product.setId(id);
//        System.out.println("************: getId "+product.getId());
//        System.out.println("****************"+id);
        try {
            ProdcutType prodcutType = productTypeRepo.findById(product.getIdTypeProduct()).get();
            Product product1 = productRepo.findById(id).get();
            product1.setName(product.getName());
            product1.setProdcutType(prodcutType);
            logger.info("Update produit ok: ");
            productRepo.save(product1);
            return product1 == null ? Response
                    .badRequest()
                    .setErrors("Error 400") : Response
                    .internalServerError()
                    .setErrors("Error 500")
                    .notFound()
                    .setErrors("Error 404")
                    .ok()
                    .setData(product1)
                    .setMessage("Produit modifié avec success");
        } catch (Exception e) {
            e.printStackTrace();
            return Response
                    .exception()
                    .setErrors(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    Boolean deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }

    @GetMapping(value = "/getAll")
    public Response<?> getALlProduct() {
        try {
            List<Product> productList = productService.lisProducts();
            return productList == null ? Response
                    .badRequest()
                    .setErrors("Error 400") : Response
                    .internalServerError()
                    .setErrors("Error 500")
                    .notFound()
                    .setErrors("Error 404")
                    .ok()
                    .setData(productList)
                    .setMessage("Récupération de la liste des produits avec success");
        } catch (Exception e) {
            e.printStackTrace();
            return Response
                    .exception()
                    .setErrors(e.getMessage());
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ProductForm {
    private Long id;
    private String name;
    private Long idTypeProduct;
}
