package tests;

import org.jsoup.Connection;
import org.testng.annotations.*;

import static locators.MainPageSelenide.*;

public class MainPageTestSuite extends BaseTest {


    @Test
    public void verifyThatBannerIsPresent() {
        bannerIsDisplayed();
    }

    @Test(dataProvider="customSearch")
    public void customSearch(String query) {
        validateSearch(query);
    }

    @Test
    public void changedLanguage() {
        languageIsChanged();
    }

    @Test(dataProvider = "invalidCredentials", groups = "languageChanged")
    public void invalidLogin(String email, String password) {
        login(email, password);
        errorMessageShown("Введено невірну адресу ел. пошти або номер телефону");
    }

    @Test(dataProvider = "invalidCredentials")
    public void incorrectLogin(String email, String password) {
        login(email, password);

    }

}
