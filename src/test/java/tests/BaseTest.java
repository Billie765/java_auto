package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import static locators.MainPageSelenide.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeSuite
    public void suiteSetUp() {
        System.out.println("Before Suite setUp runs");
        Configuration.startMaximized = true;
    }

    @BeforeTest
    public void testSetUp() {
        System.out.println("Before Test setUp runs");
        Configuration.timeout = 15000;
    }

    @BeforeClass
    public void classSetUp() {
        System.out.println("Before Class setUp runs");
        Configuration.browser = "chrome";
    }

    @BeforeGroups(groups = "languageChanged")
    public void groupSetUp() {
        System.out.println("Before Group SetUp runs");
        changeLanguage();
    }

    @BeforeMethod
    public void setUp() {
        open("https://rozetka.com.ua/");
    }

    @AfterMethod
    public void cleanUp() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @AfterGroups(groups = "languageChanged")
    public void groupCleanUp() {
        System.out.println("After Groups cleanUp runs");
    }

    @AfterClass
    public void classCleanUp() {
        System.out.println("After Class cleanUp runs");
    }

    @AfterTest
    public void testCleanUp() {
        System.out.println("After Test CleanUp runs");
    }

    @AfterSuite
    public void suiteCleanUp() {
        System.out.println("After Suite Clean Up runs");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] InvalidCredentials() {
        return new Object[][]{
                {"test@test.com", "test"},
                {"wrong", ""},
                {"", "wrong"},
                {"", ""}
        };
    }

    @DataProvider(name = "customSearch")
    public Object[][] customSearch() {
        return new Object[][]{
                {"Samsung"},
                {"Apple"},
        };
    }
}
