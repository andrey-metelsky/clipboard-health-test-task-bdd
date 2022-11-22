package utils.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.awaitility.Durations;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.awaitility.Awaitility.await;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CommonHelper {
    public static final Duration DEFAULT_TIMEOUT = Durations.TEN_SECONDS;

    public static void waitForCondition(final int maxWaitSec, final int waitIntervalSec,
                                        final Callable<Boolean> condition, final String errorMessage) {
        try {
            await().timeout(maxWaitSec, TimeUnit.SECONDS)
                    .pollInterval(waitIntervalSec, TimeUnit.SECONDS)
                    .until(condition);
        } catch (ConditionTimeoutException cte) {
            throw new RuntimeException(errorMessage, cte);
        }
    }

    public void waitForConditionWithDelay(final String message, final Duration pollInterval, final Duration timeout,
                                           final ExpectedCondition<WebElement> condition) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(timeout)
                .pollingEvery(pollInterval)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage(message);

        wait.until(condition);

    }

    public void waitForConditionWithDelay(final String message, final Duration pollInterval,
                                           final ExpectedCondition<WebElement> condition) {
        waitForConditionWithDelay(message, pollInterval, DEFAULT_TIMEOUT, condition);
    }

    public void waitForPageLoad(int timeOutInSeconds) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }
}