package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;
//import pages.*;

public class GettingStartedHelpTests extends TestBase{
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
        //qaHaifa56Page = new CurrentBoardHelper(driver, BOARD_TITLE);
        upperMenuPage= PageFactory.initElements(driver, UpperMenuHelper.class);
        helpPage= PageFactory.initElements(driver, HelpPageHelper.class);
        gettingStartedGuidePage= PageFactory.initElements(driver, GettingStartedGuideHelper.class);

        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        //qaHaifa56Page.openCurrentBoard();
        //qaHaifa56Page.waitUntilPageIsLoaded();

        upperMenuPage.openMenuPage();
        upperMenuPage.waitUntilPageIsLoaded();
        upperMenuPage.openHelpMenu();
        helpPage.waitUntilPageIsLoaded();

    }

    @Test
    public void clickHelpInUpRightMenu() {

        helpPage.chooseGettingStartedGuide();
        //helpPage.waitUntilNewPageIsLoaded();
        gettingStartedGuidePage.switchToWindowAndWaitPageLoading();

        Assert.assertEquals(gettingStartedGuidePage.getTitle(), "Getting Started with Trello",
                "Actual title is not equal to expected title");

    }
}
