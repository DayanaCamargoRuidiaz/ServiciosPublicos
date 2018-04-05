/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas_JUnit;

import Bussines.SubsidyTypeBussines;
import Entidades.EntSubsidiesType;
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
public class SubsidyTypeTest {
    
    public SubsidyTypeTest() {
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
   
    
    SubsidyTypeBussines subsidytype = new SubsidyTypeBussines();
    EntSubsidiesType entsubsidytype = new EntSubsidiesType();
    String id_subsidyTypes;
        
    @Test
    public void saveSubsidyType() throws Exception {
        System.out.println("Guardar tipo de subsidio");
        entsubsidytype.setNombre("Fijo");
        entsubsidytype.setDescripcion("Valor fijo");
        entsubsidytype.setValueAtDiscretion(Double.valueOf("500"));
        
        String result = subsidytype.saveSubsidyType(entsubsidytype);
        assertEquals("¡¡Bien!! : Tipo de Subsidio '" + entsubsidytype.getNombre() + "' guardado exitosamente", result); 
        
    }
    
     @Test
    public void deleteSubsidyType() throws Exception {
        System.out.println("Eliminar tipo de subsidio");
        
        id_subsidyTypes = "38";
        
        String result = subsidytype.deleteSubsidyType(id_subsidyTypes);
        assertEquals("¡¡Bien!! : Registro borrado exitosamente", result);        
    }
    
    
}
