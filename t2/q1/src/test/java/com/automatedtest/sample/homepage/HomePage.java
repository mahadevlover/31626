package com.automatedtest.sample.homepage;

import com.automatedtest.sample.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage{

    private static final String HOME_PAGE_URL = "https://imajbet****.com/tr";

    @FindBy(css = ".popup_container")
    private WebElement popup;

    @FindBy(css = ".close_btn")
    private WebElement closeButton;

    @FindBy(css = ".login-btn")
    private WebElement loginButton;

    @FindBy(css = "#username")
    private WebElement username;

    @FindBy(css = "#login-password")
    private WebElement loginPassword;

    @FindBy(css = ".sgn-btn")
    private WebElement login;

    @FindBy(css = ".message-box")
    private WebElement errorMessage;

    HomePage() {
        PageFactory.initElements(driver, this);
    }

    void goToHomePage(){
        driver.get(HOME_PAGE_URL);
        wait.forLoading(5);
    }

    void clickPopUp() {
        wait.forElementToBeDisplayed(5, this.popup, "popup");
        if(this.popup.isDisplayed()){
            closeButton.click();
        }else{
            System.out.print("element is not displayed");
        }
    }

    void clickLoginButton() {
        loginButton.click();
    }

    void fillUsername(String username) {
        this.username.sendKeys(username);
    }

    void fillPassword(String loginPassword) {
        this.loginPassword.sendKeys(loginPassword);
    }

    void login() {
       login.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    String getErrorMessage() {
        String expectedElementText = errorMessage.getText();
        return expectedElementText;
    }

    String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
}
