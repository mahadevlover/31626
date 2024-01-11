package com.automatedtest.sample.signuppage;

import com.automatedtest.sample.basepage.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.Random;


public class SignupPage extends BasePage{

    @FindBy(css = ".register-btn")
    private WebElement signupButton;

    @FindBy(css = "#username")
    private WebElement registerUsername;

    @FindBy(css = "#firstName")
    private WebElement registerFirstName;

    @FindBy(css = "#password")
    private WebElement registerPassword;

    @FindBy(css = "#surname")
    private WebElement registerSurname;

    @FindBy(css = "#email")
    private WebElement registerEmail;

    @FindBy(css = "#phone")
    private WebElement registerPhone;

    @FindBy(css = "label[for=gender-M]")
    private WebElement registerSelectGenderMan;

    @FindBy(css = "#days")
    private WebElement registerBirthDay;

    @FindBy(css = "#months")
    private WebElement registerBirthMonth;

    @FindBy(css = "#years")
    private WebElement registerBirthYear;

    @FindBy(css = "#cityName")
    private WebElement registerCityName;

    @FindBy(css = "#address")
    private WebElement registerAddress;

    @FindBy(css = "#countryId")
    private WebElement registerCountry;

    @FindBy(css = "label[for=privacyPolicy]")
    private WebElement registerPrivacyPolicy;

    @FindBy(css = "label[for=termsAndConditions]")
    private WebElement registerTermsAndConditions;

    @FindBy(xpath = "//button[contains(text(),'Üye Ol')]")
    private WebElement registerButton;

    @FindBy(css = ".signup-success h4")
    private WebElement signupSuccessText;

    SignupPage() {
        PageFactory.initElements(driver, this);
    }

    void clickSignupButton() {
        signupButton.click();
    }

    void signup() {
        wait.forElementToBeDisplayed(10, this.registerButton, "testbutton");
        registerButton.click();
    }

    void fillArea() {
        this.registerUsername.sendKeys("test", randomValue());
        this.registerPassword.sendKeys("OtomasyonImaj1.");
        this.registerFirstName.sendKeys("TestName");
        this.registerSurname.sendKeys("TestSurName");
        this.registerEmail.sendKeys("test" + randomValue() + "@test.com" );
        this.registerPhone.sendKeys("55533322"+randomValue());

        registerSelectGenderMan.click();

        clickComboBox(registerCountry,1);

        clickComboBox(registerBirthDay,1);
        clickComboBox(registerBirthMonth,1);
        clickComboBox(registerBirthYear,1);

        this.registerCityName.sendKeys("Istanbul");
        this.registerAddress.sendKeys("This is test address for automation.");

        this.registerPrivacyPolicy.click();
        this.registerTermsAndConditions.click();
    }

    String getSuccessMessage() {
        String expectedElementText = signupSuccessText.getText();
        return expectedElementText;
    }

    void clickComboBox(WebElement comboName, Integer selectOption) {
        Select selectElement = new Select(comboName);
        selectElement.selectByIndex(selectOption);
    }

    String randomValue(){
        Random rand = new Random();
        int randomIntValue = rand.nextInt(100);
        String stringIntRandom = String.valueOf(randomIntValue);
        return stringIntRandom;
    }
}
