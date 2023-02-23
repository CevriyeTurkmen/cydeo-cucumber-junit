package com.cydeo.runners;

import io.cucumber.core.gherkin.Feature;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.awt.*;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = "html:target/cucumber-report.html",
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
