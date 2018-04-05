package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class ciclos_Page {

    private static WebElement element = null;

    public static WebElement btnCiclos(WebDriver driver) {

        element = driver.findElement(By.id("btnC"));

        return element;

    }

    public static WebElement txtName(WebDriver driver) {

        element = driver.findElement(By.id("name"));

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

    public static WebElement btnGuardar(WebDriver driver) {

        element = driver.findElement(By.id("btnG"));
       
        return element;

    }
    
     public static WebElement tdName(WebDriver driver) {

        element = driver.findElement(By.id("nameCycle"));
       
        return element;

    }
    
}
