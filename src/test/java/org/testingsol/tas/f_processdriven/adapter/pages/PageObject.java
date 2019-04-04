package org.testingsol.tas.f_processdriven.adapter.pages;

import org.junit.platform.commons.support.ReflectionSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testingsol.tas.f_processdriven.adapter.driver.DriverFactory;

import java.util.List;

public class PageObject {

    private WebDriver driver;

    public PageObject() {
        this.driver = DriverFactory.getReusableDriver();
        PageFactory.initElements(driver, this);
    }

    protected void ensurePageContext() {
        Page pageDef = getClass().getAnnotation(Page.class);
        if (!driver.getCurrentUrl().equalsIgnoreCase(pageDef.url())) {
            driver.get(pageDef.url());
        }
    }

    public PageObject initPage(final String name) {
        return PageFactory.initElements(driver, findPageObject(name));
    }

    public PageObject navigateToPage(final String name) {
        PageObject page = initPage(name);
        page.ensurePageContext();
        return page;
    }

    public Page findPage(final String name) {
        List<Class<?>> classList = findPageClasses(name);
        if (classList.isEmpty()) throw new RuntimeException("Could not find page with name: " + name);
        return classList.get(0).getAnnotation(Page.class);
    }

    public Class<? extends PageObject> findPageObject(final String name) {
        List<Class<?>> classList = findPageClasses(name);
        if (classList.isEmpty()) throw new RuntimeException("Could not find page object with name: " + name);
        return (Class<? extends PageObject>) (classList.get(0));
    }

    private List<Class<?>> findPageClasses(final String name) {
        final String packageWithPages = "org.testingsol.tas.f_processdriven.adapter.pages";
        return ReflectionSupport.findAllClassesInPackage(packageWithPages,
                clazz -> clazz.isAnnotationPresent(Page.class)
                        && clazz.getAnnotation(Page.class).name().equals(name),
                className -> className.contains("Page"));
    }
}
