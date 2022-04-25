package cat.copernic.HardwaRepair;

import cat.copernic.HardwaRepair.DAO.CategoriaDAO;
import cat.copernic.HardwaRepair.Model.Categoria;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

/**
 *
 * @author lktol
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class categoriaTest {

    @Autowired
    CategoriaDAO cdao;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCrearCategoria() {
        Categoria categoria = cdao.save(new Categoria("Categoria de prueba"));
        assertThat(categoria.getNom()).isNotEqualTo("");
    }

    @Test
    @Order(2)
    public void testUpdateCategoria() {
        Categoria cat = cdao.findByNom("Categoria de prueba");
        cat.setNom("Categoria");
        cdao.save(cat);
        Categoria cat2 = cdao.findByNom("Categoria");

        assertThat(cat2.getNom()).isEqualTo("Categoria");
    }

    @Test
    @Order(3)
    public void testReadCategoria() {
        Categoria readedCat = cdao.findByNom("Categoria");
        assertThat(readedCat.getNom()).isEqualTo("Categoria");
    }

    @Test
    @Order(4)
    public void testDropCategoria() {
        Categoria categoria = cdao.findByNom("Categoria");
        cdao.delete(categoria);
        
        Categoria dropped = cdao.findByNom("Categoria");
        assertThat(dropped).isNull();
    }
}
