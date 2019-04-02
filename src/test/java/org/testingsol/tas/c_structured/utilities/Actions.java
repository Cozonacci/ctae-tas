package org.testingsol.tas.c_structured.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public final class Actions {

    private Actions() throws IllegalAccessException {
        throw new IllegalAccessException("Private Constructor: Static context available");
    }

    public static void goToPage(final WebDriver driver, final String url){
        driver.get(url);
    }

    public static void clickOn(final WebDriver driver, final By elementLocator){
        driver.findElement(elementLocator).click();
    }

    public static void type(final WebDriver driver, final By elementLocator, final String text){
        driver.findElement(elementLocator).sendKeys(text);
    }

    public static void selectByValue(final WebDriver driver, final By elementLocator, final String value){
        new Select(driver.findElement(elementLocator)).selectByValue(value);
    }
}
