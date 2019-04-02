package org.testingsol.tas.c_structured;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testingsol.tas.c_structured.utilities.Pages;

import static org.testingsol.tas.c_structured.utilities.Actions.*;

@ExtendWith(SeleniumExtension.class)
public class ExploreCaliforniaTest {

    @Test
    public void shouldNavigateToContactPage(ChromeDriver driver) {
        goToPage(driver, Pages.HOME_PAGE_URL);
        clickOn(driver, Pages.ContactPage.MENU_ITEM);
        Assertions.assertEquals(Pages.ContactPage.TITLE, driver.getTitle(), "Navigation: Incorrect page");
    }

    @Test
    public void shouldFillInContactPageForm(ChromeDriver driver) {

        goToPage(driver, Pages.HOME_PAGE_URL);
        clickOn(driver, Pages.ContactPage.MENU_ITEM);
        Assertions.assertEquals(Pages.ContactPage.TITLE, driver.getTitle(), "Navigation: Incorrect page");

        type(driver, Pages.ContactPage.NAME_TEXTFIELD, "John Donovan");
        type(driver, Pages.ContactPage.EMAIL_TEXTFIELD, "John.Donovan@outlook.com");
        type(driver, Pages.ContactPage.PHONE_TEXTFIELD, "403 233 2332");
        type(driver, Pages.ContactPage.ADDRESS_TEXTFIELD, "34th Street Ave NE, Seattle");
        selectByValue(driver, Pages.ContactPage.STATE_DROPDOWN, "WA");
        type(driver, Pages.ContactPage.ZIPCODE_TEXTFIELD, "98034");
    }
}
