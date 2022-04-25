package cat.copernic.HardwaRepair;

import cat.copernic.HardwaRepair.DAO.ProducteDAO;
import cat.copernic.HardwaRepair.Model.Producte;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jcadafalch
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class producteTesting {

    @Autowired
    ProducteDAO repo;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateProduct() {
        Producte savedProduct = repo.save(new Producte("Producte 1", 10.99, 22.99, "Marca 1", 2L));
        assertThat(savedProduct.getIdProducte()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void testFindProductByName() {
        Producte product = repo.findByNom("Producte 1");
        assertThat(product.getNom()).isEqualTo("Producte 1");
    }

    @Test
    @Order(3)
    public void testListProducts() {
        List<Producte> productes = (List<Producte>) repo.findAll();
        assertThat(productes.size()).isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void testUpdateProduct() {
        Producte product = repo.findByNom("Producte 1");
        product.setMarca("Intel");
        repo.save(product);

        Producte updatedProduct = repo.findByNom("Producte 1");
        assertThat(updatedProduct.getMarca()).isEqualTo("Intel");
    }

    @Test
    @Rollback(false)
    @Order(5)
    public void testDeleteProduct() {
        Producte product = repo.findByNom("Producte 1");
        repo.delete(product);

        Producte deletedProduct = repo.findByNom("Producte 1");
        assertThat(deletedProduct).isNull();
    }
}
