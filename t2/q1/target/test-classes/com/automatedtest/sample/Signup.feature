Feature: Signup scenarios

  Background: Go to register page
    Given A user navigates to home page
    When Click close pop-up button if pop-up exist
    And Click signup button

  Scenario: Create a new user
    When Fill the blank area for signup
    And Signup
    Then Should see success message is "Kaydınız tamamlanmıştır."

  Scenario: Check signup url
    Then Should see url include "authentication/signup"