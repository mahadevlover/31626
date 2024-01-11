package Pages;

import Pages.CartPage;
import Pages.Main;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Main {

    public HomePage(ChromeDriver driver){
        super(driver);
    }
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addToCartLight;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartValue;

    @FindBy(id = "shopping_cart_container")
    WebElement cartLink;

    @FindBy(className = "inventory_item_name")
    List<WebElement> listOfAlliItems;

    @FindBy(css = "button.btn.btn_primary.btn_small.btn_inventory")
    List<WebElement> listOfAllButtons;


    public void clickOnAddToCartBackpack(){
        addToCartBackpack.click();
    }
    public void clickOnAddToCartLight(){
        addToCartLight.click();
    }
    public String getCartValue(){
        try {
            return cartValue.getText();
        } catch (NoSuchElementException e){
            return "0";
        }
    }
    public CartPage clickOnCartLink(){
        cartLink.click();
        return new CartPage(driver);
    }
}
