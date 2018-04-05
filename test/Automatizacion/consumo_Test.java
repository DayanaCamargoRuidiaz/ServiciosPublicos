package Automatizacion;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Import package pageObject.*
import pageObjects.consumo_Page;

public class consumo_Test {

    private static WebDriver driver = null;
    String idHome = "3";
    String idCycle = "3";
    String elect = "200";
    String agua = "300";
    String gas = "400";
  

    @Test
    public void testRegistrarHogar() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8084/Servicios_Publicos/Consumos.jsp");

        // Use page Object library now
        consumo_Page.btnConsumo(driver).click();
        consumo_Page.txtIdHome(driver).sendKeys(idHome);
        consumo_Page.txtIdCycle(driver).sendKeys(idCycle);
        consumo_Page.txtElectricity(driver).sendKeys(elect);
        consumo_Page.txtWater(driver).sendKeys(agua);
        consumo_Page.txtGas(driver).sendKeys(gas);
        consumo_Page.btnGuardar(driver).click();
        System.out.println("Caso correcto");
        driver.quit();
    }
}
