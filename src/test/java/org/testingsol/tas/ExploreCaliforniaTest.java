package org.testingsol.tas;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@ExtendWith(SeleniumExtension.class)
public class ExploreCaliforniaTest {

    @Test
    public void shouldNavigateToContactPage(ChromeDriver driver) {

        driver.get("https://www.explorecalifornia.org/index.htm");

        driver.findElement(By.xpath(".//*[@id='siteNav']/ul/li[5]")).click();

        Assertions.assertEquals("A little about us...", driver.getTitle(),
                "Navigation: Incorrect page");
    }

    @Test
    public void shouldFillInContactPageForm(ChromeDriver driver) {

        driver.get("https://www.explorecalifornia.org/index.htm");

        driver.findElement(By.xpath(".//*[@id='siteNav']/ul/li[5]")).click();

        Assertions.assertEquals("A little about us...", driver.getTitle(),
                "Navigation: Incorrect page");

        driver.findElement(By.id("name")).sendKeys("John Donovan");
        driver.findElement(By.id("email")).sendKeys("John.Donovan@outlook.com");
        driver.findElement(By.id("phone")).sendKeys("403 233 2332");
        driver.findElement(By.id("address")).sendKeys("34th Street Ave NE, Seattle");
        new Select(driver.findElement(By.id("state"))).selectByValue("WA");
        driver.findElement(By.id("zip")).sendKeys("98034");
    }
}
