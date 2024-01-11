package Pages;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main  {
    ChromeDriver driver;

    public Main(ChromeDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }


}
