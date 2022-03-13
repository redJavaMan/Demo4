package Launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Automation {

    @BeforeClass
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        WebElement women = driver.findElement(By.xpath("//a[contains(.,'Women')]"));
        Actions action = new Actions(driver);
        action.moveToElement(women).perform();
        WebElement tShirt = driver.findElement(By.xpath("(//a[contains(.,'T-shirts')])[1]"));
        tShirt.click();
        Thread.sleep(5000);
        WebElement fadedShortSleeve = driver.findElement(By.xpath("//a[contains(.,'Faded Short Sleeve T-shirts')]"));
        fadedShortSleeve.click();
        WebElement addToCart = driver.findElement(By.xpath("//span[contains(.,'Add to cart')]"));
        addToCart.click();
        Thread.sleep(5000);
        WebElement proceedToCheckout = driver.findElement(By.xpath("//span[contains(.,'Proceed to checkout')]"));
        proceedToCheckout.click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(.,'Faded Short Sleeve T-shirts')]")).getText(),"Faded Short Sleeve T-shirts");
        WebElement proceedToPay = driver.findElement(By.xpath("(//a[contains(.,'Proceed to checkout')])[2]/child::span"));
        proceedToPay.click();
        driver.quit();




    }
}
