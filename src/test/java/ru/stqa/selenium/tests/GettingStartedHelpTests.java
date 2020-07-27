package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;
//import pages.*;

public class GettingStartedHelpTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardHelper qaHaifa56Page;
    UpperMenuHelper upperMenuPage;
    HelpPageHelper helpPage;
    GettingStartedGuideHelper gettingStartedGuidePage;

    @BeforeMethod
    public void initTests() throws InterruptedException {

        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        upperMenuPage= PageFactory.initElements(driver, UpperMenuHelper.class);
        helpPage= PageFactory.initElements(driver, HelpPageHelper.class);
        gettingStartedGuidePage= PageFactory.initElements(driver, GettingStartedGuideHelper.class);

        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        upperMenuPage.openMenuPage();
        upperMenuPage.waitUntilPageIsLoaded();
        upperMenuPage.openHelpMenu();
        helpPage.waitUntilPageIsLoaded();
    }

    @Test
    public void clickHelpInUpRightMenu() {
        log4j.startTestCase("clickHelpInUpRightMenu");
        log4j.info("Choose link text 'Getting Started Guide'");
        helpPage.chooseGettingStartedGuide();

        log4j.info("Switch to window 'Getting Started Guide' and wait until page is loaded");
        gettingStartedGuidePage.switchToWindowAndWaitPageLoading();

        log4j.info("Test result verification (assert): Text title is 'Getting Started with Trello'");
        Assert.assertEquals(gettingStartedGuidePage.getTitle(), "Getting Started with Trello",
                "Actual title is not equal to expected title");
        log4j.endTestCase();
    }
}
