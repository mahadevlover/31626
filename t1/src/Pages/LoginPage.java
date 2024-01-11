package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Main {
    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy (css = ".error-message-container > h3:nth-child(1)")
    WebElement errorMessage;

    public LoginPage(ChromeDriver driver){
        super(driver);
        driver.get("https://www.saucedemo.com/");
        PageFactory.initElements(driver, this);
    }
    public void enterUsername(String username){
        userNameField.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public HomePage clickLoginButtonValid(){
        loginButton.click();
        return new HomePage(driver);
    }
    public void clickLoginButtonInvalid(){
        loginButton.click();
    }
    public HomePage login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButtonValid();
        return new HomePage(driver);
    }
    public boolean isErrorMessageDisplayed(){
        return errorMessage.isDisplayed();
    }
    public String getErrorMessageText(){
        return errorMessage.getText();
    }
    public void equalHomePageUrl(){
        String homePageUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(homePageUrl, clickLoginButtonValid().getUrl(), "Home page isn't open.");
    }
}
