package org.testingsol.tas.e_keyworddriven.extensions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.support.AnnotationSupport;
import org.testingsol.tas.e_keyworddriven.helper.FileLoader;
import org.testingsol.tas.e_keyworddriven.procedure.Scenario;

import java.io.IOException;
import java.util.Optional;

public class JsonScenarioParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Scenario.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {

        Optional<JsonScenario> scenarioAnnotation =
                AnnotationSupport.findAnnotation(extensionContext.getTestMethod(), JsonScenario.class);

        if (!scenarioAnnotation.isPresent())
            throw new IllegalStateException(
                    "Please provide a scenario resource using @JsonScenario test annotation");

        ObjectMapper mapper = new ObjectMapper();
        try {
            String content =  FileLoader.read("classpath:" + scenarioAnnotation.get().value());
            return mapper.readValue(content, Scenario.class);
        } catch (IOException e) {
            throw new ParameterResolutionException("Exception encountered while reading/parsing the scenario file: "
                    + e.getMessage());
        }
    }
}
