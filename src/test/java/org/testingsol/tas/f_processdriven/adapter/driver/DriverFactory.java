package org.testingsol.tas.f_processdriven.adapter.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory {

    private final WebDriver driver;
    private static DriverFactory instance;

    static {
        WebDriverManager.chromedriver().setup();
    }

    private DriverFactory() {
        driver = new ChromeDriver();
    }

    public static final DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public static final WebDriver getReusableDriver() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance.driver;
    }

    public void closeSession() {
        driver.quit();
    }
}
