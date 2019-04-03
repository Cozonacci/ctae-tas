package org.testingsol.tas.e_keyworddriven.mappers;

import org.openqa.selenium.By;

public final class LocatorMapper {

    private LocatorMapper() {
    }

    public static By from(String criteria, String target) {
        switch (criteria) {
            case "byXpath":
                return By.xpath(target);
            case "byId":
                return By.id(target);
            default:
                throw new IllegalArgumentException("Cannot determine locator based on: " + criteria);
        }
    }
}
