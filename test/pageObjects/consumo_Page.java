
package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class consumo_Page {
    
       private static WebElement element = null;

    public static WebElement btnConsumo(WebDriver driver) {

        element = driver.findElement(By.id("btnCo"));

        return element;

    }

    public static WebElement txtIdHome(WebDriver driver) {

        element = driver.findElement(By.id("idHome"));

        return element;

    }

    public static WebElement txtIdCycle(WebDriver driver) {

        element = driver.findElement(By.id("idCycle"));

        return element;

    }

    public static WebElement txtElectricity(WebDriver driver) {

        element = driver.findElement(By.id("electricity"));

        return element;

    }

    public static WebElement txtWater(WebDriver driver) {

        element = driver.findElement(By.id("water"));

        return element;

    }
    
    public static WebElement txtGas(WebDriver driver) {

        element = driver.findElement(By.id("naturalGas"));

        return element;

    }
    public static WebElement btnGuardar(WebDriver driver) {

        element = driver.findElement(By.id("btnG"));

        return element;

    }
}
