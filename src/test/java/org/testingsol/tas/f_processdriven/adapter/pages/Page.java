package org.testingsol.tas.f_processdriven.adapter.pages;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Page {

    String name();

    String url();
}
