/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automatizacion;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Import package pageObject.*
import pageObjects.personas_Page;

public class personas_Test {

    private static WebDriver driver = null;
    String nombre = "Test";
    String apellido = "Test Tes";
    String documento = "101720237";
    String email = "test@gmail.com";
    
    @Test
    public void testRegistrarHogar() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8084/Servicios_Publicos/personas.jsp");

        // Use page Object library now
        personas_Page.btnPersona(driver).click();
        personas_Page.txtName(driver).sendKeys(nombre);
        personas_Page.txtLast(driver).sendKeys(apellido);
        personas_Page.txtDocumento(driver).sendKeys(documento);
        personas_Page.txtEmail(driver).sendKeys(email);
        personas_Page.btnRegistrar(driver).click();
        System.out.println("Caso correcto");
        driver.quit();
    }
}
