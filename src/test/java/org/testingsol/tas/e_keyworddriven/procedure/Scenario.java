package org.testingsol.tas.e_keyworddriven.procedure;

import java.util.ArrayList;
import java.util.List;

public class Scenario {

    private String name;
    private List<Step> steps = new ArrayList<>();

    public Scenario() {
    }

    public Scenario(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public static final Scenario EMPTY_SCENARIO = new Scenario("Empty Scenario");
}
