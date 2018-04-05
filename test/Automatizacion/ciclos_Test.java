package Automatizacion;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.ciclos_Page;

public class ciclos_Test {

    private static WebDriver driver = null;

    String nombre = "Test";
    String StartD = "01/01/2018";
    String EndD = "15/01/2018";

    @Test
    public void testRegistrarCiclos() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8084/Servicios_Publicos/ciclos_consumo.jsp");

        // Use page Object library now
        ciclos_Page.btnCiclos(driver).click();

        ciclos_Page.txtName(driver).sendKeys(nombre);
        ciclos_Page.txtStart(driver).sendKeys(StartD);
        ciclos_Page.txtEnd(driver).sendKeys(EndD);
        ciclos_Page.btnGuardar(driver).click();

       /* Alert alert = driver.switchTo().alert();
        alert.getText();
        System.out.println("Mensaje de alerta" + alert);
        driver.switchTo().alert().accept();

        driver.switchTo().defaultContent();*/
        System.out.println("Guardado exitoso");
        driver.quit();
    }
}
