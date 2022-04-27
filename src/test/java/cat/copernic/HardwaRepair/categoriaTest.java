package cat.copernic.HardwaRepair;

import cat.copernic.HardwaRepair.DAO.CategoriaDAO;
import cat.copernic.HardwaRepair.Model.Categoria;
import cat.copernic.HardwaRepair.serveis.Categoria.CategoriaServiceInterface;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author lktol
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class categoriaTest {

    @Autowired
    CategoriaDAO cdao;
    @Autowired
    CategoriaServiceInterface categoriaService;
    Categoria categoria;

    @BeforeEach
    void info() {
        categoria = new Categoria();
        categoria.setNom("prueba");
    }

    @Test
    @Order(1)
    public void testCrearCategoria() {
        categoriaService.afegirCategoria(categoria);
    }

    @Test
    @Order(2)
    public void testUpdateCategoria() {
        Categoria cat = cdao.findByNom("prueba");
        cat.setNom("Categoria");
        categoriaService.afegirCategoria(cat);

        Categoria cat2 = cdao.findByNom("Categoria");
        assertThat(cat2.getNom()).isEqualTo("Categoria");
    }

    @Test
    @Order(3)
    public void testReadCategoria() {
        List<Categoria> list = categoriaService.llistarCategoria();
        assertThat(list.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void testDropCategoria() {
        categoriaService.eliminarCategoria(cdao.findByNom("Categoria"));

        Categoria dropped = cdao.findByNom("Categoria");
        assertThat(dropped).isNull();
    }
}
