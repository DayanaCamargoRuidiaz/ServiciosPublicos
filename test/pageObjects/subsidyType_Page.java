/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class subsidyType_Page {
    
      private static WebElement element = null;

    public static WebElement btnST(WebDriver driver) {

        element = driver.findElement(By.id("btnST"));

        return element;

    }

    public static WebElement txtNombre(WebDriver driver) throws InterruptedException {

        Thread.sleep(1000);
        element = driver.findElement(By.id("Nombre"));

        return element;

    }

    public static WebElement txtDescripcion(WebDriver driver) {

        element = driver.findElement(By.id("Descripcion"));

        return element;

    }

    public static WebElement txtValueAtDiscretion(WebDriver driver) {

        element = driver.findElement(By.id("ValueAtDiscretion"));

        return element;

    }

    public static WebElement btnGuardar(WebDriver driver) {

        element = driver.findElement(By.id("btnG"));

        return element;

    }

    
}
