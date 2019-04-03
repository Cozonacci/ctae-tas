package org.testingsol.tas.e_keyworddriven.extensions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.testingsol.tas.e_keyworddriven.procedure.Scenario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonScenarioParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Scenario.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {

        String scenarioPath = System.getenv("json-scenario-path"); //THIS WILL BE PROVIDED EXTERNALLY
        if (scenarioPath == null || scenarioPath.isEmpty())
            throw new ParameterResolutionException("Please provide the path for json scenario file");

        //TODO: JUnit 5 does not see custom (user-defined) annotations
        //Optional<JsonScenario> anno =
        // AnnotationSupport.findAnnotation(extensionContext.getTestMethod(), JsonScenario.class);

        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = new String(Files.readAllBytes(Paths.get(scenarioPath)));
            return mapper.readValue(json, Scenario.class);
        } catch (IOException e) {
            throw new ParameterResolutionException("Exception encountered while reading/parsing the scenario file: "
                    + e.getMessage());
        }
    }
}
