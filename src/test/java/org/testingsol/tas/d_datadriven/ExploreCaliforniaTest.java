package org.testingsol.tas.d_datadriven;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testingsol.tas.c_structured.utilities.Pages;

import static org.testingsol.tas.c_structured.utilities.Actions.*;

@ExtendWith(SeleniumExtension.class)
public class ExploreCaliforniaTest {

    @ParameterizedTest(name = "{index}: Sending feedback from {0}")
    @CsvSource({
            "John Donovan,  John.Donovan@outlook.com,   403 233 2332,   '34th Street Ave NE, Seattle',  WA, 98034",
            "Helen Donovan, Helen.Donovan@outlook.com,  403 231 2334,   '32th Street Ave NE, Seattle',  WA, 98033"
    })
    public void shouldFillInContactPageForm(String name, String email, String phone,
                                            String address, String state, String zip,
                                            ChromeDriver driver) {

        goToPage(driver, Pages.HOME_PAGE_URL);
        clickOn(driver, Pages.ContactPage.MENU_ITEM);
        Assertions.assertEquals(Pages.ContactPage.TITLE, driver.getTitle(), "Navigation: Incorrect page");

        type(driver, Pages.ContactPage.NAME_TEXTFIELD, name);
        type(driver, Pages.ContactPage.EMAIL_TEXTFIELD, email);
        type(driver, Pages.ContactPage.PHONE_TEXTFIELD, phone);
        type(driver, Pages.ContactPage.ADDRESS_TEXTFIELD, address);
        selectByValue(driver, Pages.ContactPage.STATE_DROPDOWN, state);
        type(driver, Pages.ContactPage.ZIPCODE_TEXTFIELD, zip);
    }
}
