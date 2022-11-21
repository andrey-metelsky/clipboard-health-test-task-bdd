package com.clipboardhealth.implementations.pages;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;

@Accessors(fluent = true)
@Getter
public class ProductDetailsPage extends BasePage {

    private final By itemDescription = By.xpath("//div[@id='featurebullets_feature_div']");

}
