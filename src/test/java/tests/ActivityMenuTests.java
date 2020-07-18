package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;
import util.DataProviders;
//import pages.*;

public class ActivityMenuTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardHelper qaHaifa56Page;
    UpperMenuHelper upperMenuPage;
    ActivityPageHelper activityPage;

    @BeforeMethod
    public void initTests() throws InterruptedException {

        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        qaHaifa56Page = new CurrentBoardHelper(driver,BOARD_TITLE);
        upperMenuPage = PageFactory.initElements(driver, UpperMenuHelper.class);
        activityPage = PageFactory.initElements(driver, ActivityPageHelper.class);

        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        qaHaifa56Page.openCurrentBoard();
        qaHaifa56Page.waitUntilPageIsLoaded();
    }
   @Test(dataProviderClass = DataProviders.class,dataProvider = "DPActivityMenuTests")
    public void addingNewListEventInActivity(String listTitle){
       log4j.startTestCase("loginTestPositive");
       log4j.info("Create new list event activity: "+listTitle);
       qaHaifa56Page.createNewList(listTitle);
       log4j.info("Open upper menu page");
       upperMenuPage.openMenuPage()
                    .waitUntilPageIsLoaded()
                    .openActivityPage();

       log4j.info("Activity page screen is loading");
        activityPage.waitUntilPageIsLoaded();

       log4j.info("Test result (assert): The text in the last activity record doesn't correspond to event adding new list "+ listTitle);
       Assert.assertTrue(activityPage.getLastActivityText().contains(" added list "+ listTitle + " to "),
               "The text in the last activity record doesn't correspond to event adding new list " + listTitle );
        log4j.endTestCase();
    }

}
