package locators;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[text()=' UA ']")
    private WebElement languageSelector;
    @FindBy(xpath = "//img[@alt='Rozetka Logo']")
    private WebElement logo;
    @FindBy(className = "header__button")
    private WebElement catalogButton;
    @FindBy(partialLinkText = "Средство для мытья")
    private WebElement cleaningStuff;
    @FindBy(css = "div > input")
    private WebElement inputField;
    @FindBy(xpath = "/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button")
    private WebElement profileButton;
    @FindBy(id = "auth_email")
    private WebElement loginField;
    @FindBy(id = "auth_pass")
    private WebElement passField;
    @FindBy(className = "exponea-popup-banner")
    private WebElement banner;
    @FindBy(className = "button_size_large")
    private WebElement addToCart;
    @FindBy(css = "div.modal__content")
    private WebElement cartWindow;
    @FindBy(css = "h1.catalog-heading")
    private WebElement catalogHeading;
    @FindBy(css="button.search-form__submit")
    private WebElement searchSubmit;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openMainPage() {
        driver.get("https://rozetka.com.ua/");
    }

    public void languageIsChanged() {
        languageSelector.click();
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            @NullableDecl
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return driver.findElement(By.xpath("//p[text()=\" Спробуйте \"]")).isDisplayed();
            }
        });
    }

    public void logoPresent() {
        Assertions.assertTrue(logo.isDisplayed());
    }

    public void headerButtonPresent() {
        Assertions.assertTrue(catalogButton.isDisplayed());
    }

    public void searchWorks(String query) {
        inputField.click();
        inputField.sendKeys(query);
        searchSubmit.click();
        wait.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return driver.findElement(By.cssSelector("h1.catalog-heading")).isDisplayed();
            }
        });
        String title = driver.getTitle();
        Assertions.assertTrue(title.startsWith("Смартфоны - ROZETKA. Купить смартфон"), title);
    }

    public void bannerIsPresent() {
        Assertions.assertTrue(banner.isDisplayed());
    }

    public void loginFieldsDisplayed() {
        profileButton.click();
        Assertions.assertTrue(loginField.isDisplayed());
        Assertions.assertTrue(passField.isDisplayed());
    }

    public void addItemToCart() {
        cleaningStuff.click();
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
        Assertions.assertTrue(cartWindow.isDisplayed());
    }
}
