package com.quantum.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.Test;


@CucumberOptions(
        features="src/main/resources/scenarios/mayoApiTests.feature",
        glue="com.quantum.steps"

)

public class ApiRunner {
    @Test
    public void runCukes() {

        new TestNGCucumberRunner(getClass()).runCukes();

    }

}
