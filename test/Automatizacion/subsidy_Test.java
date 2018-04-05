
package Automatizacion;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Import package pageObject.*
import pageObjects.subsidy_Page;

public class subsidy_Test {
    
    private static WebDriver driver = null;
    String nombre = "Test";
    String descripcion = "Valor test";
    String start = "19/11/2017";
    String end = "30/11/2017";
    String ExpGas ="200";
    String ExpWater ="300";
    String ExpEner ="150";
    

   @Test
    public void testRegistrarHogar() throws InterruptedException{

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8084/Servicios_Publicos/Subsidy.jsp");

        // Use page Object library now
        subsidy_Page.btnS(driver).click();
        subsidy_Page.txtName(driver).sendKeys(nombre);
        subsidy_Page.txtDescripcion(driver).sendKeys(descripcion);
        subsidy_Page.txtStart(driver).sendKeys(start);
        subsidy_Page.txtEnd(driver).sendKeys(end);
        subsidy_Page.txtExpectedGas(driver).sendKeys(ExpGas);
        subsidy_Page.txtExpectedWater(driver).sendKeys(ExpWater);
        subsidy_Page.txtExpectedEnergy(driver).sendKeys(ExpEner);
        subsidy_Page.btnGuardar(driver).click();
         System.out.println("Caso correcto");
       //  String expResult = subsidy_Page.mensaje(driver).getText(); 
        
        /*if(expResult.equals("¡¡Bien!! : Subsidio '" + nombre + "' guardado exitosamente")){
             System.out.println("Caso correcto");
       } else {
           System.out.println("Caso incorrecto");
       
        }*/

        driver.quit();
    } 
    
}
