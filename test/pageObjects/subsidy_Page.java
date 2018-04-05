
package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class subsidy_Page {
   
     private static WebElement element = null;

    public static WebElement btnS(WebDriver driver) {

        element = driver.findElement(By.id("btnS"));

        return element;

    }

    public static WebElement txtName(WebDriver driver) throws InterruptedException {

        Thread.sleep(1000);
        element = driver.findElement(By.id("name"));

        return element;

    }

    public static WebElement txtDescripcion(WebDriver driver) {

        element = driver.findElement(By.id("description"));

        return element;

    }

    public static WebElement txtStart(WebDriver driver) {

        element = driver.findElement(By.id("startDate"));

        return element;

    }

    public static WebElement txtEnd(WebDriver driver) {

        element = driver.findElement(By.id("endDate"));

        return element;

    }
    
    public static WebElement txtExpectedGas(WebDriver driver) {

        element = driver.findElement(By.id("expectedNaturalGasValue"));

        return element;

    }
    
    public static WebElement txtExpectedWater(WebDriver driver) {

        element = driver.findElement(By.id("expectedWaterValue"));

        return element;

    }
    
    public static WebElement txtExpectedEnergy(WebDriver driver) {

        element = driver.findElement(By.id("expectedEnergyValue"));

        return element;

    }
    
    public static WebElement btnGuardar(WebDriver driver) {

        element = driver.findElement(By.id("btnG"));

        return element;

    }
    
}
