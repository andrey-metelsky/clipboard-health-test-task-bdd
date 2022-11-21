package com.clipboardhealth.stepdefinitions.frontend;

import io.cucumber.java.en.Then;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;

public class ProductDetailsSteps extends UIInteractionSteps {

    @Steps
    private ProductDetailsPage productDetailsPage;

    @Then("I print item details text to the console")
    public void iPrintItemDetailsToConsole() {
        System.out.println($(productDetailsPage.itemDescription()).getText());
    }
}
