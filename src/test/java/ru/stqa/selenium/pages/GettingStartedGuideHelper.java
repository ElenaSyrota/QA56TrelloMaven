package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GettingStartedGuideHelper extends PageBase {

    @FindBy(xpath = "//a[@class = 'global-header-section-button'][contains(text(),'Go to Your Boards')]")
    WebElement goToYourBoardsUpperButton;

    public GettingStartedGuideHelper(WebDriver driver) {
        super(driver);
    }

    public void switchToWindowAndWaitPageLoading(){
        log4j.info("---Class GettingStartedGuideHelper,method - switchToWindowAndWaitPageLoading was started");
        log4j.info("Wait until number of windows was two");
        waitUntilNumberOfWindows(2,30);
        String anotherHandle = getAnotherWindowHandle(driver.getWindowHandle());
        switchToWindow(anotherHandle);
        log4j.info("Wait until link text 'Go to Your Boards' is clickable");
        waitUntilElementIsClickable(goToYourBoardsUpperButton,20);
    }
}
