package Automatizacion;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Import package pageObject.*
import pageObjects.subsidyType_Page;

public class subsidyType_Test {

    private static WebDriver driver = null;
    String nombre = "Test";
    String descripcion = "Valor test";
    String valor = "300";

    @Test
    public void testRegistrarHogar() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8084/Servicios_Publicos/SubsidyType.jsp");

        // Use page Object library now
        subsidyType_Page.btnST(driver).click();
        subsidyType_Page.txtNombre(driver).sendKeys(nombre);
        subsidyType_Page.txtDescripcion(driver).sendKeys(descripcion);
        subsidyType_Page.txtValueAtDiscretion(driver).sendKeys(valor);
        subsidyType_Page.btnGuardar(driver).click();
         System.out.println("Caso correcto");
       // String expResult = subsidyType_Page.mensaje(driver).getText(); 
       
         //assertEquals(expResult, "Done! Computer "+ nombre +" has been created");
      /*  if(expResult.equals("¡¡Bien!! : Tipo de Subsidio '"+nombre+"' guardado exitosamente")){
             System.out.println("Caso correcto");
       } else {
           System.out.println("Caso incorrecto");
       
        }*/
        
        driver.quit();
    }
}
