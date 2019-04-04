package org.testingsol.tas.f_processdriven.domain;

import org.testingsol.tas.f_processdriven.model.Customer;

/**
 * This interface will aggregate the core capabilities of the application.
 */
public interface AppFacade {

    void leaveCustomerContactDetails(Customer customer);

    AppFacade navigateToPage(String page);
}
