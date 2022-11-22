package com.clipboardhealth.implementations.pages;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static java.lang.String.format;

@Accessors(fluent = true)
@Getter
public class CategoryPage extends BasePage {

    private String filterRowInSection = "//*[@id='s-refinements']//span[text()='%s']" +
            "//ancestor::div/following-sibling::ul//span[text()='%s']";
    private final By sortByBtn = By.xpath("//*[@data-action='a-dropdown-button']");
    private String sortByOption = "//li[@class='a-dropdown-item']/a[text()='%s']";
    private final By searchResultItem = By.xpath("//div[contains(@class, 's-card-container')]");

    @Step("Select filter {0} from {1} section")
    public void selectFilterRowInSection(String filterName, String sectionName) {
        WebElementFacade filterRow = $(format(filterRowInSection, sectionName, filterName));
        scrollToElement(filterRow);
        clickElement(filterRow);
    }

    @Step("Open SortBy dropdown")
    public void openSortByDropDown() {
        clickElement($(sortByBtn));
    }

    @Step("Select sort option {0}")
    public void selectSortOption(String sortOption) {
        clickElement($(format(sortByOption, sortOption)));
    }

    @Step("Select search results item located at position {0}")
    public void selectSearchResultItemByPosition(int position) {
        clickElement($$(searchResultItem).get(position - 1));
    }
}
