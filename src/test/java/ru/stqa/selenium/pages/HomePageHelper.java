package ru.stqa.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase {
    @FindBy(linkText = "Log In")
    WebElement loginIcon;

    @FindBy(xpath = "//a[contains(text(), 'About')]")
    WebElement aboutFooter;

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
        log4j.info("---Class HomePageHelper,method - waitUntilPageIsLoaded was started");
        waitUntilElementIsClickable(loginIcon,20);
    }


    public String getAboutFooter() {
        return aboutFooter.getText();
    }

    public void scrollDownToViewFooter() {
        scrollDownToViewElement(aboutFooter);
    }


}
