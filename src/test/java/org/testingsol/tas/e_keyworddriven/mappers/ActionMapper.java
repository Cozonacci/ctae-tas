package org.testingsol.tas.e_keyworddriven.mappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testingsol.tas.e_keyworddriven.procedure.Step;

public final class ActionMapper {

    private ActionMapper() {
    }

    public static void execute(final WebDriver driver, final Step step) {
        switch (step.getAction()) {
            case "goto": {
                driver.get(step.getParams().getTarget());
                return;
            }
            case "click": {
                By webElementLocator = LocatorMapper.from(step.getParams().getCriteria(), step.getParams().getTarget());
                driver.findElement(webElementLocator).click();
                return;
            }
            case "type": {
                By webElementLocator = LocatorMapper.from(step.getParams().getCriteria(), step.getParams().getTarget());
                driver.findElement(webElementLocator).sendKeys(step.getParams().getValue());
                return;
            }
            case "selectByValue": {
                By webElementLocator = LocatorMapper.from(step.getParams().getCriteria(), step.getParams().getTarget());
                new Select(driver.findElement(webElementLocator)).selectByValue(step.getParams().getValue());
                return;
            }
            default:
                throw new IllegalArgumentException("Cannot determine action based on: " + step.getAction());
        }
    }
}
