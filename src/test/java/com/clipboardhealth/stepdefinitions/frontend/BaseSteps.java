package com.clipboardhealth.stepdefinitions.frontend;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.text.CaseUtils;


import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseSteps extends UIInteractionSteps {

    private static final String THE_USER = "The user";
    public static final int DEFAULT_WAIT_TIME = 10;

    @Steps
    private BasePage basePage;
    private HomePage homePage;

    @Given("I am on the {string} page")
    public void navigateToPage(final String pageName) {
        Actor.named(THE_USER)
                .can(BrowseTheWeb.with(this.getDriver()))
                .attemptsTo(Open.browserOn().thePageNamed(CaseUtils.toCamelCase(pageName, false)));
    }

    @When("I open navigation menu")
    public void iOpenNavMenu() {
        homePage.clickElement($(homePage.navMenuBtn()));
    }

    @When("I select {string} row in the menu")
    public void iSelectMenuRow(String rowName) {
        homePage.selectMenuRowByName(rowName);
    }

    @When("I navigate to the new browser tab")
    public void iNavigateToTheNewBrowserTab() {
        basePage.switchWindow();
    }

    @Then("I should see {string} text on the page")
    public void iShouldSeeElementWithText(String text) {
        assertThat($(format(basePage.elementWithText(), text)).waitUntilVisible().isVisible())
                .as(format("check visibility of '%s' text on the page", text))
                .isTrue();
    }
}

