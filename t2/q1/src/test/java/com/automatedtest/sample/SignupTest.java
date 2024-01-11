package com.automatedtest.sample;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/automatedtest/sample/Signup.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/signup-page.json",
        "html:target/home-page-html"},
        glue = {"com.automatedtest.sample.infrastructure.driver",
                "com.automatedtest.sample.signuppage","com.automatedtest.sample.homepage"})
public class SignupTest {
}
