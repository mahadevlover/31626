package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAndRemoveTests extends BaseTest{
    String username = "standard_user";
    String password = "secret_sauce";
    String expectedBackpackItemName = "Sauce Labs Backpack";
    String expectedLightItemName = "Sauce Labs Bike Light";

    @Test
    public void addNewProductToCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(username, password);
        Assert.assertEquals("0",homePage.getCartValue(), "Cart isn't empty.");
        homePage.clickOnAddToCartBackpack();
        Assert.assertEquals("1",homePage.getCartValue(), "Cart has more or less than one item.");
        CartPage cartPage = homePage.clickOnCartLink();
        Assert.assertEquals(cartPage.backpackCart(),expectedBackpackItemName);
    }

    @Test
    public void addMoreProductsToCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(username, password);
        Assert.assertEquals("0",homePage.getCartValue(), "Cart isn't empty.");
        homePage.clickOnAddToCartBackpack();
        homePage.clickOnAddToCartLight();
        Assert.assertEquals("2",homePage.getCartValue(), "Cart has more or less than two items.");
        CartPage cartPage = homePage.clickOnCartLink();
        Assert.assertEquals(cartPage.backpackCart(),expectedBackpackItemName);
        Assert.assertEquals(cartPage.lightCart(), expectedLightItemName);
    }
    @Test
    public void removeAllProductsFromCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(username,password);
        Assert.assertEquals("0", homePage.getCartValue(), "Cart isn't empty.");
        homePage.clickOnAddToCartBackpack();
        homePage.clickOnAddToCartLight();
        Assert.assertEquals("2", homePage.getCartValue(), "Cart has more or less than two items.");
        homePage.clickOnCartLink();
        CartPage cartPage = new CartPage(driver);
        cartPage.removeBackpackFromCart();
        cartPage.removeLightFromCart();
        Assert.assertEquals("0",homePage.getCartValue(), "Cart isn't empty.");
    }

}
