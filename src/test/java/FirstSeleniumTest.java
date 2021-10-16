import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @Test
    public void findByPartialLinkTextAndByCSS() {
        WebElement item = driver.findElement(By.partialLinkText("Средство для мытья"));
        item.click();
        var waiter = new WebDriverWait(driver, 5);
        waiter.until(new ExpectedCondition<Boolean>() {
            @Override
            @NullableDecl
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector("img.thumbnail__picture")).isDisplayed();
            }
        });
    }

    @Test
    public void findElementByRelativeXPATHText() throws InterruptedException {
        WebElement item = driver.findElement(By.xpath("//*[text()=' UA ']"));
        item.click();
        //WebElement item = driver.findElement(By.partialLinkText("Средство для мытья"));
        //var waiter = new WebDriverWait(driver, 5);
        //waiter.until(new ExpectedCondition<Boolean>() {
            //@Override
           // @NullableDecl
            //public Boolean apply(@NullableDecl WebDriver webDriver) {
                //return webDriver.findElement(By.partialLinkText("Средство для мытья")).isDisplayed();
            //}
        //});
    }

    @Test
    public void findElementByAttributeXpath() {
        WebElement item = driver.findElement(By.xpath("//img[@alt='Rozetka Logo']"));
    }

    @Test
    public void findElementByClassName() {
        WebElement item = driver.findElement(By.className("header__button"));
    }

    @Test
    public void findElementChildByCSS() {
        WebElement item = driver.findElement(By.cssSelector("div > input"));
    }

    @Test
    public void findElementsByTagName() {
        var images = driver.findElements(By.tagName("img"));
        System.out.println(images.size());
    }

    @Test
    public void findElementByAbsoluteXpathandIds() {
        WebElement userLogin = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button"));
        userLogin.click();
        WebElement loginField = driver.findElement(By.id("auth_email"));
        loginField.sendKeys("test@test.com");
        WebElement passField = driver.findElement(By.id("auth_pass"));
        passField.sendKeys("password");
        passField.submit();
    }

    @Test public void FindElementsByID() {
        WebElement userLogin = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/ul/li[3]/rz-user/button"));
        userLogin.click();
        WebElement loginField = driver.findElement(By.id("auth_email"));
        loginField.sendKeys("test@test.com");
        WebElement passField = driver.findElement(By.id("auth_pass"));
        passField.sendKeys("password");
        passField.submit();
    }

    @Test
    public void FindPopupByClass() {
        WebElement popup = driver.findElement(By.className("exponea-popup-banner"));
        popup.click();
    }

    @Test
    public void FindElementByAttribute() {
        WebElement cartButton = driver.findElement(By.xpath("//button[@opencart]"));
        cartButton.click();
        var waiter = new WebDriverWait(driver, 5);
        waiter.until(new ExpectedCondition<Boolean>() {
        @Override
        @NullableDecl
        public Boolean apply(@NullableDecl WebDriver webDriver) {
        return webDriver.findElement(By.cssSelector("div.cart")).isDisplayed();
        }
        });
    }
}