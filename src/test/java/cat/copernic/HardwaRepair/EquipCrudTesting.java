package cat.copernic.HardwaRepair;

import cat.copernic.HardwaRepair.DAO.EquipDAO;
import cat.copernic.HardwaRepair.DAO.EquipDAO;
import cat.copernic.HardwaRepair.Model.Equip;
import cat.copernic.HardwaRepair.Model.Equip;
import cat.copernic.HardwaRepair.serveis.Equip.EquipServiceInterface;
import cat.copernic.HardwaRepair.serveis.Equip.EquipServiceInterface;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author marc
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EquipCrudTesting {
    
    @Autowired
    private EquipServiceInterface equipService;

    @Autowired
    private EquipDAO equipDAO;

    Equip testEquip;

    @BeforeEach
    void info(){
        testEquip = new Equip();
        testEquip.setNum_serie("12345A");
        testEquip.setClient_id("00000000T");
        testEquip.setDescripcio("Hola");
        testEquip.setMarca("MSI");
        testEquip.setModel("AASDX");
        testEquip.setTipus_equip_id(1);
        
    }

    @Test
    @Order(1)
    void testAfegirEquip(){
        equipService.afegirEquip(testEquip);
    }

    @Test
    @Order(2)
    void testLlistarEquips() {
        List<Equip> equips = equipService.llistarEquips();
        assertThat(equips.size()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    void testModificarEquip(){
        Equip equip = equipDAO.findByMarca("MSI");
        equip.setDescripcio("Nou");
        equipService.afegirEquip(equip);

        Equip updatedProduct = equipDAO.findByMarca("MSI");
        assertThat(updatedProduct.getDescripcio()).isEqualTo("Nou");
    }

    @Test
    @Order(4)
    void testEliminarEquip(){
        equipService.eliminarEquip(equipDAO.findByMarca("MSI"));

        Equip deletedProduct = equipDAO.findByMarca("MSI");
        assertThat(deletedProduct).isNull();
    }


}