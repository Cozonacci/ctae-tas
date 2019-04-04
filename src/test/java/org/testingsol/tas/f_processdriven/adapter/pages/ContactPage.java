package org.testingsol.tas.f_processdriven.adapter.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testingsol.tas.f_processdriven.adapter.ContactFeatures;
import org.testingsol.tas.f_processdriven.model.Customer;

@Page(name = "Contact", url = "https://www.explorecalifornia.org/contact.htm")
public class ContactPage extends PageObject implements ContactFeatures {

    @FindBy(id = "name")
    private WebElement nameTextField;
    @FindBy(id = "email")
    private WebElement emailTextField;

    @Override
    public void leaveCustomerContactDetails(Customer customer) {
        ensurePageContext();
        nameTextField.sendKeys(customer.getName());
        emailTextField.sendKeys(customer.getEmail());
    }
}
