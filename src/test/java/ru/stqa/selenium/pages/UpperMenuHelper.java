package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpperMenuHelper extends PageBase {
    @FindBy(xpath = "//button[@data-test-id = 'header-member-menu-button']")
    WebElement upperRight;
    @FindBy(xpath = "//a[@data-test-id = 'header-member-menu-profile']")
    WebElement profilevisabilityMenuItem;
    @FindBy(xpath = "//span[contains(text(),'Activity')]/..")
    WebElement activityMenuItem;
    @FindBy(xpath = "(//span[contains(text(),'Activity')]/..)[2]")
    WebElement activityMenuItemFromCurrentBoard;
    @FindBy(xpath = "//button/span[contains(text(),'Help')]")
    WebElement helpMenuItem;


    public UpperMenuHelper(WebDriver driver) {
        super(driver);
    }

    public UpperMenuHelper waitUntilPageIsLoaded(){
        log4j.info("Wait until profile menu item is clickable");
        waitUntilElementIsClickable(profilevisabilityMenuItem,20);
        log4j.info("Wait until Activity menu item is clickable");
        waitUntilElementIsClickable(activityMenuItem,20);
        log4j.info("Wait until help menu item page is clickable");
        waitUntilElementIsClickable(helpMenuItem,20);
        return this;
    }

    public void openProfileVisabilityScreen(){
        profilevisabilityMenuItem.click();
    }

    public UpperMenuHelper openMenuPage(){
        log4j.info("---Class UpperMenuHelper,method - openMenuPage was started");
        log4j.info("Wait until button upper right menu is clickable");
        waitUntilElementIsClickable(upperRight,20);
        log4j.info("Click on the button upper right menu");
        upperRight.click();
        return this;
    }

    public UpperMenuHelper openActivityPage() {
        log4j.info("---Class UpperMenuHelper,method - openActivityPage was started");
        log4j.info("Click on the activity menu item from Current board");
        activityMenuItemFromCurrentBoard.click();
        return this;
    }

    public void openHelpMenu(){
        log4j.info("---Class UpperMenuHelper,method - openHelpMenu was started");
        log4j.info("Click on the help menu item from Current board");
        helpMenuItem.click();
    }


}