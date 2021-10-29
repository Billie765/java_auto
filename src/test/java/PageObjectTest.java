import locators.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObjectTest {

    WebDriver driver;
    MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void languageChecked() {
        mainPage.languageIsChanged();
    }

    @Test
    public void logoPresent() {
        mainPage.logoPresent();
    }

    @Test
    public void headerButtonPresent() {
        mainPage.headerButtonPresent();
    }

    @Test
    public void searchQuery() {
        mainPage.searchWorks("смартфон");
    }

    @Test
    public void bannerDisplayed() {
        mainPage.bannerIsPresent();
    }

    @Test
    public void loginFieldsDisplayed() {
        mainPage.loginFieldsDisplayed();
    }

    @Test
    public void addItemToCart() {
        mainPage.addItemToCart();
    }
}
