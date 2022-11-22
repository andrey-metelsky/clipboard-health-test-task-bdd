package com.clipboardhealth.stepdefinitions.frontend;

import com.clipboardhealth.implementations.pages.ProductDetailsPage;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDetailsSteps extends UIInteractionSteps {

    private static final Logger logger = LoggerFactory.getLogger(ProductDetailsSteps.class);

    @Steps
    private ProductDetailsPage productDetailsPage;

    @Then("I print item details text to the console")
    public void iPrintItemDetailsToConsole() {
        String detailsText = $(productDetailsPage.itemDescription()).getText();
        //printing to the console
        logger.info(detailsText);
        //adding to the report
        Serenity.recordReportData().withTitle("Item details text").andContents(detailsText);
    }
}
