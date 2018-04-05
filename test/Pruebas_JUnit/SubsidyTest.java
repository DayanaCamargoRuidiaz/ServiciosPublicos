/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas_JUnit;

import Bussines.SubsidyBussines;
import Entidades.EntHomeXCicle_Subsidies;
import Entidades.EntSubsidies;
import Persistencia.DaosSubsidies;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josef
 */
public class SubsidyTest {
    
    public SubsidyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        
        
    }

    /**
     * Test of save
     */
    
     SubsidyBussines subsidy = new SubsidyBussines();
     EntSubsidies entsubsidy = new EntSubsidies();
     String idSybsudy;
    
    @Test
    public void saveSubsidy() throws Exception {
        System.out.println("Guardar tipo de subsidio");
        entsubsidy.setName("SubsidioTestt");
        entsubsidy.setDescription("Subsidio de pruebas");
        entsubsidy.setStartDate(Date.valueOf("2017-10-09"));
        entsubsidy.setEndDate(Date.valueOf("2017-10-30"));
        entsubsidy.setExpectedWaterValue(Double.valueOf("100"));
        entsubsidy.setExpectedNaturalGasValue(Double.valueOf("200"));
        entsubsidy.setExpectedEnergyValue(Double.valueOf("100"));
        entsubsidy.setType(1);    
        
        String result = subsidy.saveSubsidy(entsubsidy);
        
        assertEquals("¡¡Bien!! : Subsidio 'SubsidioTestt' guardado exitosamente", result);      
    }
   
     @Test
    public void deleteSubsidyType() throws Exception {
        System.out.println("Eliminar tipo de subsidio");
        idSybsudy = "24";
        
        String result = subsidy.deleteSubsidy(idSybsudy);
        assertEquals("¡¡Bien!! : Registro borrado exitosamente", result);        
        
    }
    
}
