package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.Main;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    String username = "standard_user";
    String password = "secret_sauce";
    String wrongUsername = "standard-user";
    String wrongPassword = "secret-sauce";
    String homePageUrl = "https://www.saucedemo.com/inventory.html";
    String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";


    @Test
    public void testLoginInvalidData(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(wrongUsername);
        loginPage.enterPassword(wrongPassword);
        loginPage.clickLoginButtonInvalid();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed.");
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage, "Not valid error message text.");

    }

    @Test
    public void testLoginValidData(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        HomePage homePage = loginPage.clickLoginButtonValid();
        Assert.assertEquals(homePageUrl, homePage.getUrl(), "Home page isn't opened.");
    }
}
