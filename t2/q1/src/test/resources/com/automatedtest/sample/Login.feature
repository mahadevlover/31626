Feature: Login scenarios

  Background: Go to login page
    Given A user navigates to home page
    When Click close pop-up button if pop-up exist
    And Click login button

  Scenario: Check closed account
    When Fill username "a"
    And Fill password "123"
    And Login
    Then Should see error message is "Hesap giriş işlemine kapalıdır"

  Scenario: Check invalid account
    When Fill username "wrongusername"
    And Fill password "wrongpassword"
    And Login
    Then Should see error message is "Yanlış kullanıcı adı veya şifre girdiniz, kontrol edip tekrar deneyin"

  Scenario: Check valid account
    When Fill username "otomasyondeneme"
    And Fill password "Automation1."
    And Login
    #Then Should see url include "signup-success"
    #Email is not valid, scenario can not be successful.