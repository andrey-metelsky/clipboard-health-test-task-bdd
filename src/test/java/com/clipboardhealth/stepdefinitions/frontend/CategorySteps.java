package com.clipboardhealth.stepdefinitions.frontend;

import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;

import static com.clipboardhealth.stepdefinitions.frontend.BaseSteps.DEFAULT_WAIT_TIME;

public class CategorySteps extends UIInteractionSteps {

    @Steps
    private CategoryPage categoryPage;

    @When("I select {string} filter in the {string} section")
    public void iSelectFilter(String filterName, String sectionName) {
        categoryPage.selectFilterRowInSection(filterName, sectionName);
        categoryPage.waitForPageBeingLoaded(DEFAULT_WAIT_TIME);
    }

    @When("^I sort products by (Featured|Price: Low to High|Price: High to Low|Avg. Customer Review|Newest Arrivals)$")
    public void iSortProducts(String sortOption) {
        categoryPage.openSortByDropDown();
        categoryPage.selectSortOption(sortOption);
        categoryPage.waitForPageBeingLoaded(DEFAULT_WAIT_TIME);
    }


    @When("I select search result item at position {int}")
    public void iSelectSearchResultItemByPosition(int position) {
        categoryPage.selectSearchResultItemByPosition(position);
    }
}
