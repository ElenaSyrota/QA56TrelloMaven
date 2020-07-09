package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPageHelper extends PageBase {

    @FindBy(xpath = "//ul[@id='search-results']//a[contains(text(),'Getting Started Guide')]")
    WebElement helpItem;

    @FindBy(linkText = "Getting Started Guide")
    WebElement helpGettingStartedGuide;

    @FindBy(xpath = "//a[@class='global-header-section-button']")
    WebElement btnNewPageHelp;

    @FindBy(xpath = "//div[@class='atlaskit-portal']//iframe")
    WebElement frameNameHelp;

    @FindBy(xpath = "//div[@id='iframe-io-host']//iframe")
    WebElement frameNameHelp1;


    public HelpPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {

        waitUntilElementIsVisible(frameNameHelp, 30);

    }

    public void chooseGettingStartedGuide() {

        waitUntilElementIsClickable(helpGettingStartedGuide,15);

        System.out.println("Current window: " + driver.getWindowHandle());
        driver.switchTo().frame(frameNameHelp);
        helpGettingStartedGuide.click();

    }

    public void waitUntilNewPageIsLoaded() {

         waitUntilFrameIsLoadedAndSwitchToIt(frameNameHelp,30);


    }

    public void newPage() {

        String firstWindow = driver.getWindowHandle();
        System.out.println("Current window: " + driver.getWindowHandle());
        String secondWindow = "";
        for (String uId : driver.getWindowHandles()) {
            if (!uId.equals(firstWindow)) secondWindow = uId;
        }
        driver.switchTo().window(secondWindow);
        System.out.println("Current new window: " + driver.getWindowHandle());
        System.out.println("Text: " + driver.findElement(By.xpath("//h1[contains(text(),'Getting Started With Trello')]")).getText());
        driver.close();
        driver.switchTo().window(firstWindow);
    }

    public String getNewPageTitle() {
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Getting Started With Trello')]")).getText());
       return driver.findElement(By.xpath("//h1[contains(text(),'Getting Started With Trello')]")).getText();
    }

}
