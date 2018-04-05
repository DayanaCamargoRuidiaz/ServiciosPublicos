package Automatizacion;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Import package pageObject.*
import pageObjects.hogar_Page;

public class hogar_Test {

    private static WebDriver driver = null;
    String direccion = "Calle Test";
    String telefono = "4442103";
    String identificacionRe = "3";
   

   @Test
    public void testRegistrarHogar(){

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8084/Servicios_Publicos/Hogares.jsp");

        // Use page Object library now
        hogar_Page.btnHogar(driver).click();
        hogar_Page.txtDireccion(driver).sendKeys(direccion);
        hogar_Page.txtTelefono(driver).sendKeys(telefono);
        hogar_Page.txtidentificacionRe(driver).sendKeys(identificacionRe);
        hogar_Page.btnGuardar(driver).click();
        System.out.println("Caso correcto");
        driver.quit();
    }
}
