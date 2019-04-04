package org.testingsol.tas.f_processdriven.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testingsol.tas.f_processdriven.domain.AppFacade;
import org.testingsol.tas.f_processdriven.domain.AppFacadeImpl;
import org.testingsol.tas.f_processdriven.model.Customer;

public class StepDefs {

    private Customer customer;
    private AppFacade appFacade = AppFacadeImpl.getInstance();

    @Given("{string} is a new customer")
    public void a_new_customer(final String name) {
        customer = new Customer(name);
    }

    @When("he navigates to {string} page")
    public void user_navigates_to_page(final String page) {
        appFacade.navigateToPage(page);
    }

    @Then("should be able to leave his contact details")
    public void user_should_be_able_to_leave_contact_details() {
        appFacade.leaveCustomerContactDetails(customer);
    }
}