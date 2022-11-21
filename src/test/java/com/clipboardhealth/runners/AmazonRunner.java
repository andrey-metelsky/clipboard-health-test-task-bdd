package com.clipboardhealth.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/frontend/Amazon.feature",
        glue = {"com.clipboardhealth.stepdefinitions.frontend"},
        plugin = {
                "pretty"
        }
)
public class AmazonRunner {
}
