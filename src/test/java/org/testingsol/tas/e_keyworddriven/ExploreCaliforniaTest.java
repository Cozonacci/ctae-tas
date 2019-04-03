package org.testingsol.tas.e_keyworddriven;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testingsol.tas.e_keyworddriven.extensions.JsonScenarioParameterResolver;
import org.testingsol.tas.e_keyworddriven.mappers.ActionMapper;
import org.testingsol.tas.e_keyworddriven.procedure.Scenario;

@ExtendWith(SeleniumExtension.class)
class ExploreCaliforniaTest {

    @BeforeAll
    public static void setup(){
        String scenarioPath = System.getenv("json-scenario-path"); //THIS SHOULD BE PROVIDED EXTERNALLY
        if (scenarioPath == null || scenarioPath.isEmpty())
            throw new RuntimeException("Please provide the path for json scenario file, " +
                    "e.g. path/to/ExploreCalifornia.json");
    }

    @Test
    @ExtendWith(JsonScenarioParameterResolver.class)
    void shouldFillInContactPageForm(Scenario scenario, ChromeDriver driver) {
        scenario.getSteps().forEach(step -> ActionMapper.execute(driver, step));
    }
}
