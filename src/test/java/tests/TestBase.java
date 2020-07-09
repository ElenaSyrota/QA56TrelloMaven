package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import HomePageHelper;
import ru.stqa.selenium.SuiteConfiguration;
import ru.stqa.selenium.factory.WebDriverPool;
import ru.stqa.selenium.pages.HomePageHelper;

import java.io.IOException;
import java.net.URL;

public class TestBase {
    protected static URL gridHubUrl = null;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected WebDriver driver;

    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "lena.syrota@gmail.com";
    public static final String PASSWORD = "638465Lena";
    public static final String USERNAME = "elenasyrota";
    //public static final String USER_NAME_MENU = "Elena Syrota (elenasyrota)";
    HomePageHelper homePage;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        capabilities = config.getCapabilities();
    }

    @BeforeMethod
    public void initWbDriver() {

        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);driver = new ChromeDriver();
        driver.get(baseUrl);
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        homePage.waitUntilPageIsLoaded();

    }

    @AfterMethod
    public void tearDownForTest(){
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}