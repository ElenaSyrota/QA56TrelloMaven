package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.BoardsPageHelper;
import ru.stqa.selenium.pages.CurrentBoardHelper;
import ru.stqa.selenium.pages.LoginPageHelper;
import util.DataProviders;

public class CurrentBoardTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardHelper qaHaifa56Page;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        qaHaifa56Page = new CurrentBoardHelper(driver,BOARD_TITLE);
        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        qaHaifa56Page.openCurrentBoard();
        qaHaifa56Page.waitUntilPageIsLoaded();
    }

    @Test
    public void createNewList()  {
        log4j.startTestCase("createNewList");
        int beforeAdding = qaHaifa56Page.getListsQuantity();
        System.out.println("Lists before adding: " + beforeAdding);
        log4j.info("Create new list");
        qaHaifa56Page.createNewList("Test");

        int afterAdding = qaHaifa56Page.getListsQuantity();
        Assert.assertEquals(afterAdding,beforeAdding+1,
                "The quantity of lists before adding new list is not the same as the quantity after adding");
        log4j.endTestCase();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dataProviderThirdDP")
    public void createNewCard(String nameCard)  {
        log4j.startTestCase("createNewCard");
        if (!qaHaifa56Page.existsList()) qaHaifa56Page.createNewList("Test");

        int beforeAdding = qaHaifa56Page.receiveQuantityOfCards();
        qaHaifa56Page.pressAddCardButton()
                .enterTextToCard(nameCard)
                .submitAddingCard()
                .cancelEditCardMode();

        int afterAdding = qaHaifa56Page.receiveQuantityOfCards();
        Assert.assertEquals(afterAdding,beforeAdding+1,
                "The quantity of cards before adding new card is not the same as the quantity after adding");
        log4j.endTestCase();

    }
}