package org.testingsol.tas.f_processdriven;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "org.testingsol.tas.f_processdriven.definition",
        features = "src/test/resources/features")
public class ExploreCaliforniaTest {
}
