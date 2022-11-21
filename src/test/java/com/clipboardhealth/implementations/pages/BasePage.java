package com.clipboardhealth.implementations.pages;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.awaitility.Durations;
import org.openqa.selenium.support.ui.*;
import utils.helper.CommonHelper;

import java.util.Iterator;
import java.util.Set;

@Accessors(fluent = true)
@Getter
public class BasePage extends PageObject {
    protected EnvironmentVariables env;
    CommonHelper commonHelper = new CommonHelper();

    private String elementWithText = "//*[text()='%s']";

    @Step("Click '{0}' element")
    public void clickElement(final WebElementFacade element) {
        commonHelper.waitForConditionWithDelay(String.format("Element %s isn't clickable", element),
                Durations.FIVE_SECONDS,
                ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Get '{0}' element text")
    public String getElementText(final WebElementFacade element) {
        element.waitUntilPresent();
        return element.getText();
    }

    @Step("Scroll to specific webelement of the page")
    public void scrollToElement(WebElementFacade element) {
        evaluateJavascript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Switch to child window")
    public void switchWindow() {
        String parent = getDriver().getWindowHandle();
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!parent.equals(childWindow)) {
                getDriver().switchTo().window(childWindow);
            }
        }
    }

    @Step("Wait for page being loaded for {int} seconds")
    public void waitForPageBeingLoaded(int timeOutInSeconds) {
        commonHelper.waitForPageLoad(timeOutInSeconds);
    }
}
