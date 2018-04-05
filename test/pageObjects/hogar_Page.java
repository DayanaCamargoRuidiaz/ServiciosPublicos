package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class hogar_Page {

    private static WebElement element = null;

    public static WebElement btnHogar(WebDriver driver) {

        element = driver.findElement(By.id("btnH"));

        return element;

    }

    public static WebElement txtDireccion(WebDriver driver) {

        element = driver.findElement(By.id("address"));

        return element;

    }

    public static WebElement txtTelefono(WebDriver driver) {

        element = driver.findElement(By.id("landline"));

        return element;

    }

    public static WebElement txtidentificacionRe(WebDriver driver) {

        element = driver.findElement(By.id("idPerson"));

        return element;

    }

    public static WebElement btnGuardar(WebDriver driver) {

        element = driver.findElement(By.id("btnG"));

        return element;

    }

}
