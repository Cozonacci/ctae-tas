package org.testingsol.tas.c_structured.utilities;

import org.openqa.selenium.By;

public final class Pages {

    // URL PAGE CONFIGURATIONS
    public static final String APP_URL = "https://www.explorecalifornia.org";
    public static final String HOME_PAGE_URL = APP_URL + "/index.htm";

    private Pages() throws IllegalAccessException {
        throw new IllegalAccessException("Private Constructor: Static context available");
    }

    public static class ContactPage {

        // PAGE ELEMENTS AND LOCATORS
        public static final String TITLE = "A little about us...";
        public static final By MENU_ITEM = By.xpath(".//*[@id='siteNav']/ul/li[5]");

        public static final By NAME_TEXTFIELD = By.id("name");
        public static final By EMAIL_TEXTFIELD = By.id("email");
        public static final By PHONE_TEXTFIELD = By.id("phone");
        public static final By ADDRESS_TEXTFIELD = By.id("address");
        public static final By STATE_DROPDOWN = By.id("state");
        public static final By ZIPCODE_TEXTFIELD = By.id("zip");

        private ContactPage() throws IllegalAccessException {
            throw new IllegalAccessException("Private Constructor: Static context available");
        }
    }
}
