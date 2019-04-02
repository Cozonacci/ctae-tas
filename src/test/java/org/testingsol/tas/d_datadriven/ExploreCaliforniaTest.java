package org.testingsol.tas.d_datadriven;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@ExtendWith(SeleniumExtension.class)
public class ExploreCaliforniaTest {

    // URL PAGE CONFIGURATIONS
    public static final String APP_URL = "https://www.explorecalifornia.org";
    public static final String HOME_PAGE_URL = APP_URL + "/index.htm";

    // PAGE ELEMENTS AND LOCATORS
    public static final String CONTACT_PAGE_MENU_ITEM = ".//*[@id='siteNav']/ul/li[5]";
    public static final String CONTACT_PAGE_TITLE = "A little about us...";

    public static final By NAME_TEXTFIELD = By.id("name");
    public static final By EMAIL_TEXTFIELD = By.id("email");
    public static final By PHONE_TEXTFIELD = By.id("phone");
    public static final By ADDRESS_TEXTFIELD = By.id("address");
    public static final By STATE_DROPDOWN = By.id("state");
    public static final By ZIPCODE_TEXTFIELD = By.id("zip");

    @ParameterizedTest
    @CsvSource({
            "John Donovan,  John.Donovan@outlook.com,   403 233 2332,   '34th Street Ave NE, Seattle',  WA, 98034",
            "Helen Donovan, Helen.Donovan@outlook.com,  403 231 2334,   '32th Street Ave NE, Seattle',  WA, 98033"
    })
    public void shouldFillInContactPageForm(String name, String email, String phone,
                                            String address, String state, String zip,
                                            ChromeDriver driver) {

        driver.get(HOME_PAGE_URL);
        driver.findElement(By.xpath(CONTACT_PAGE_MENU_ITEM)).click();
        Assertions.assertEquals(CONTACT_PAGE_TITLE, driver.getTitle(), "Navigation: Incorrect page");

        driver.findElement(NAME_TEXTFIELD).sendKeys(name);
        driver.findElement(EMAIL_TEXTFIELD).sendKeys(email);
        driver.findElement(PHONE_TEXTFIELD).sendKeys(phone);
        driver.findElement(ADDRESS_TEXTFIELD).sendKeys(address);
        new Select(driver.findElement(STATE_DROPDOWN)).selectByValue(state);
        driver.findElement(ZIPCODE_TEXTFIELD).sendKeys(zip);
    }
}
