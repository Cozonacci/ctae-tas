package org.testingsol.tas.e_keyworddriven;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testingsol.tas.e_keyworddriven.extensions.JsonScenarioParameterResolver;
import org.testingsol.tas.e_keyworddriven.mappers.ActionMapper;
import org.testingsol.tas.e_keyworddriven.procedure.Scenario;

@ExtendWith(SeleniumExtension.class)
class ExploreCaliforniaTest {

    @Test
    @ExtendWith(JsonScenarioParameterResolver.class)
    //TODO: Look for options to load non-JUnit annotation into context
    //@JsonScenario(path = "ExploreCalifornia.json")
    void shouldFillInContactPageForm(Scenario scenario, ChromeDriver driver) {
        scenario.getSteps().forEach(step -> ActionMapper.execute(driver, step));
    }
}
