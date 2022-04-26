///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package cat.copernic.HardwaRepair.serveis;
//
//import cat.copernic.HardwaRepair.Model.Equip;
//import java.util.List;
//
//import cat.copernic.HardwaRepair.serveis.Equip.EquipService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author marc
// */
//public class EquipServiceTest {
//
//    public EquipServiceTest() {
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//    }
//
//    @BeforeEach
//    public void setUp() {
//    }
//
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of llistarEquips method, of class EquipService.
//     */
//    @Test
//    public void testLlistarEquips() {
//        System.out.println("llistarEquips");
//        EquipService instance = new EquipService();
//        List<Equip> expResult = null;
//        List<Equip> result = instance.llistarEquips();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of afegirEquip method, of class EquipService.
//     */
//    @Test
//
//    public void testAfegirEquip() {
//        System.out.println("afegirEquip");
//        Equip equip = null;
//
//        equip.setNum_serie("234234234");
//        equip.setClient_id("00000000T");
//        equip.setMarca("MSI");
//        equip.setModel("AXXX");
//        equip.setDescripcio("holaaa");
//        equip.setTipus_equip_id(1);
//
//        EquipService instance = new EquipService();
//        instance.afegirEquip(equip);
//        
//        // TODO review the generated test code and remove the default call to fail.
//        if(instance.cercarEquip(equip) != equip){
//        
//            fail("The test case is a prototype.");
//        
//        }
//    }
//
//    /**
//     * Test of cercarEquip method, of class EquipService.
//     */
//    @Test
//    public void testCercarEquip() {
//        System.out.println("cercarEquip");
//        Equip equip = null;
//        EquipService instance = new EquipService();
//        Equip expResult = null;
//        Equip result = instance.cercarEquip(equip);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarEquip method, of class EquipService.
//     */
//    @Test
//    public void testEliminarEquip() {
//        System.out.println("eliminarEquip");
//        Equip equip = null;
//        EquipService instance = new EquipService();
//        instance.eliminarEquip(equip);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//}
