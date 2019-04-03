package org.testingsol.tas.e_keyworddriven.extensions;

public @interface JsonScenario {

    String path() default "scenario.json";
}
