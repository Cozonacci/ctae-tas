package org.testingsol.tas.f_processdriven.adapter;

import org.testingsol.tas.f_processdriven.model.Customer;

/**
 * This interface represents functional sliced of the entire application.
 */
public interface ContactFeatures {

    void leaveCustomerContactDetails(Customer customer);
}
