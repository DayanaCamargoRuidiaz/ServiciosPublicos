

package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class personas_Page {
    
       private static WebElement element = null;

    public static WebElement btnPersona(WebDriver driver) {

        element = driver.findElement(By.id("btnPe"));

        return element;

    }

    public static WebElement txtName(WebDriver driver) {

        element = driver.findElement(By.id("name"));

        return element;

    }

    public static WebElement txtLast(WebDriver driver) {

        element = driver.findElement(By.id("lastName"));

        return element;

    }

    public static WebElement txtDocumento(WebDriver driver) {

        element = driver.findElement(By.id("documentNumber"));

        return element;

    }
    
      public static WebElement txtEmail(WebDriver driver) {

        element = driver.findElement(By.id("email"));

        return element;

    }

    public static WebElement btnRegistrar(WebDriver driver) {

        element = driver.findElement(By.id("btnR"));

        return element;

    }

}
