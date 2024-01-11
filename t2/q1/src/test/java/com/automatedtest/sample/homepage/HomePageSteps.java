package com.automatedtest.sample.homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class HomePageSteps {


    private HomePage homePage;

    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    @Given("^A user navigates to home page")
    public void aUserNavigatesToHomePage() {
        this.homePage.goToHomePage();
    }

    @When("Click close pop-up button if pop-up exist")
    public void clickPopUpButton() {
        this.homePage.clickPopUp();
    }

    @When("Click login button")
    public void clickLoginButton() {
        this.homePage.clickLoginButton();
    }

    @When("^Fill username \"([^\"]*)\"$")
    public void fillUsername(String username) {
        this.homePage.fillUsername(username);
    }

    @When("^Fill password \"([^\"]*)\"$")
    public void fillPassword(String password) {
        this.homePage.fillPassword(password);
    }

    @When("Login")
    public void login() {
        this.homePage.login();
    }

    @Then("^Should see error message is \"([^\"]*)\"$")
    public void errorMessage(String actualMessage) {
        String expectedElementText = this.homePage.getErrorMessage();
        Assert.assertTrue("Message is " + expectedElementText + " instead of " + actualMessage,
                actualMessage.equals(expectedElementText));
    }

    @Then("^Should see url include \"([^\"]*)\"$")
    public void checkUrlInclude(String expectedUrl) {
        String actualUrl = this.homePage.getCurrentUrl();
        Assert.assertTrue("Message is " + expectedUrl + " instead of " + actualUrl,
                actualUrl.contains(expectedUrl));
    }
}
