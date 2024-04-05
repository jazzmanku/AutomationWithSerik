package funtional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Helper;

public class TestBase {
    public ChromeDriver driver;
    @BeforeTest
    public void Setup() throws InterruptedException {

        driver  = new ChromeDriver();
        driver.get(Helper.readPropertyByKey("app_url"));
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement portfolio = driver.findElement(By.xpath("//*[@id=\"menu-item-436\"]/div/a/span"));
        actions.moveToElement(portfolio).build().perform();
        driver.findElement(By.xpath("//*[@id=\"menu-item-453\"]/div/a")).click();
        Thread.sleep(3000);

    }

    @AfterTest
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
