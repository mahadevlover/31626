package com.automatedtest.sample.signuppage;

import com.automatedtest.sample.homepage.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignupPageSteps {

    private SignupPage signupPage;

    public SignupPageSteps() {
        this.signupPage = new SignupPage();
    }

    @When("Click signup button")
    public void clickSignupButton() {
        this.signupPage.clickSignupButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Signup")
    public void login() {

        this.signupPage.signup();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Fill the blank area for signup")
    public void fillArea() {
        this.signupPage.fillArea();
    }

    @Then("^Should see success message is \"([^\"]*)\"$")
    public void errorMessage(String actualMessage) {
        String expectedElementText = this.signupPage.getSuccessMessage();
        Assert.assertTrue("Message is " + expectedElementText + " instead of " + actualMessage,
                actualMessage.equals(expectedElementText));
    }
}
