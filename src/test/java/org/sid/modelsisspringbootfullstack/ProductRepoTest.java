package org.sid.modelsisspringbootfullstack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.sid.modelsisspringbootfullstack.dao.ProductRepo;
import org.sid.modelsisspringbootfullstack.dao.ProductTypeRepo;
import org.sid.modelsisspringbootfullstack.entities.ProdcutType;
import org.sid.modelsisspringbootfullstack.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    ProductTypeRepo productTypeRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveProductTest() {
//        ProdcutType prodcutType = productTypeRepo.getById(1L);
//        Product product = Product.builder().
//                name("Boisson")
//                .created_date(new Date())
//                .prodcutType(prodcutType).build();
////        Product product = new Product(2L, "Orange", "10/Jan/2022",  prodcutType);
//        productRepo.save(product);
//        Assertions.assertThat(product.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void saveProductTypeTest() {
//        ProdcutType prodcutType = ProdcutType.builder().
//                name("Test").build();
//        productTypeRepo.save(prodcutType);
//        Assertions.assertThat(prodcutType.getId()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void getProductTest(){
        Product product = productRepo.findById(1L).get();
        Assertions.assertThat(product.getId()).isEqualTo(1L);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateProductTest(){
        Product product = productRepo.findById(1L).get();
        product.setName("Tôle");
        Product productUpdated =  productRepo.save(product);
        Assertions.assertThat(product.getName()).isEqualTo("Tôle");
    }
}
