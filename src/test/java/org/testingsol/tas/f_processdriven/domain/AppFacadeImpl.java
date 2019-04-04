package org.testingsol.tas.f_processdriven.domain;

import org.testingsol.tas.f_processdriven.adapter.ContactFeatures;
import org.testingsol.tas.f_processdriven.adapter.pages.ContactPage;
import org.testingsol.tas.f_processdriven.adapter.pages.PageObject;
import org.testingsol.tas.f_processdriven.model.Customer;

public class AppFacadeImpl implements AppFacade {

    private final ContactFeatures contactFeatures;

    private static AppFacadeImpl instance;

    private AppFacadeImpl() {
        this.contactFeatures = new ContactPage();
    }

    public static AppFacadeImpl getInstance() {
        if (instance == null) {
            instance = new AppFacadeImpl();
        }
        return instance;
    }

    @Override
    public void leaveCustomerContactDetails(Customer customer) {
        this.contactFeatures.leaveCustomerContactDetails(customer);
    }

    @Override
    public AppFacade navigateToPage(String page) {
        new PageObject().navigateToPage(page);
        return this;
    }
}
