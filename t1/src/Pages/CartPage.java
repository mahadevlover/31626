package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends Main {
    public CartPage(ChromeDriver driver){
        super(driver);
    }

    @FindBy(id = "item_4_title_link")  //  add-to-cart-sauce-labs-backpack
    WebElement backpackInventoryName;

    @FindBy(id = "item_0_title_link")
    WebElement lightInventoryName;

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpackFromInventoryCart;

    @FindBy (id = "remove-sauce-labs-bike-light")
    WebElement removeLightFromInventoryCart;


    public String backpackCart(){

        return backpackInventoryName.getText();
    }

    public String lightCart(){

        return lightInventoryName.getText();
    }


    public CartPage removeBackpackFromCart(){
        removeBackpackFromInventoryCart.click();
        return new CartPage(driver);
    }

    public CartPage removeLightFromCart(){
        removeLightFromInventoryCart.click();
        return new CartPage(driver);
    }

    @FindBy (className = "inventory_item_name")
    List <WebElement> inventoryItemNames;

    public String[] inventoryItemNames(){
        String[] inventoryItemNamesText = new String[inventoryItemNames.toArray().length];

        for (int i=0; i <inventoryItemNames.toArray().length; i++){
            inventoryItemNamesText[i] = inventoryItemNames.get(i).getText();
        }
        return inventoryItemNamesText;
    }
}
