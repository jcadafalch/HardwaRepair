package cat.copernic.HardwaRepair;

import cat.copernic.HardwaRepair.DAO.ProducteDAO;
import cat.copernic.HardwaRepair.Model.Producte;
import cat.copernic.HardwaRepair.serveis.Producte.ProducteServiceInterface;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jcadafalch
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProducteCrudTesting {
    @Autowired
    private ProducteServiceInterface producteService;

    @Autowired
    private ProducteDAO producteDAO;

    Producte testProducte;

    @BeforeEach
    void info(){
        testProducte = new Producte();
        testProducte.setNom("test");
        testProducte.setMarca("Marca");
        testProducte.setPreuCompra(20.99);
        testProducte.setPreuVenda(30.99);
        testProducte.setCategoriaId(1);
    }

    @Test
    @Order(1)
    void testAfegirProducte(){
        producteService.afegirProducte(testProducte);
    }

    @Test
    @Order(2)
    void testLlistarProductes() {
        List<Producte> productes = producteService.llistarProductes();
        assertThat(productes.size()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    void testModificarProducte(){
        Producte producte = producteDAO.findByNom("test");
        producte.setMarca("Marca modificada");
        producte.setCategoriaId(2);
        producteService.afegirProducte(producte);

        Producte updatedProduct = producteDAO.findByNom("test");
        assertThat(updatedProduct.getMarca()).isEqualTo("Marca modificada");
    }

    @Test
    @Order(4)
    void testEliminarProducte(){
        producteService.eliminarProducte(producteDAO.findByNom("test"));

        Producte deletedProduct = producteDAO.findByNom("test");
        assertThat(deletedProduct).isNull();
    }


}
