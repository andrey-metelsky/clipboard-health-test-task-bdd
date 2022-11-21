package com.clipboardhealth.implementations.pages;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import static java.lang.String.format;

@Accessors(fluent = true)
@Getter
@DefaultUrl("page:home.page")
public class HomePage extends BasePage {
    private final By navMenuBtn = By.xpath("//*[@id='nav-main']/div[@class='nav-left']");
    private String navMenuRow = "//ul[contains(@class,'hmenu-visible')]/li//*[text()='%s']";

    public void selectMenuRowByName(String rowName) {
        WebElementFacade row = $(format(navMenuRow, rowName)).waitUntilVisible();
        scrollToElement(row);
        clickElement(row);
    }
}
