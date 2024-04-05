package funtional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Helper;
import utils.OptionsManager;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    @BeforeTest
    public void Setup() throws InterruptedException {
        boolean isHeadless = Boolean.parseBoolean(Helper.readPropertyByKey("isHeadless"));
        boolean isCognito = Boolean.parseBoolean(Helper.readPropertyByKey("isCognito"));

        if(Helper.readPropertyByKey("browser").toLowerCase().equals("chrome"))
            driver  = new ChromeDriver(OptionsManager.getChromeOptions(isHeadless,isCognito));
        if(Helper.readPropertyByKey("browser").toLowerCase().equals("firefox"))
            driver  = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Helper.readPropertyByKey("default_timeout_in_seconds"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(Helper.readPropertyByKey("default_page_load_timeout_in_seconds"))));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(Helper.readPropertyByKey("default_script_timeout_in_seconds"))));
        navigateToApplication();

    }

    private void navigateToApplication() throws InterruptedException {
        driver.get(Helper.readPropertyByKey("dev_app_url"));
        Actions actions = new Actions(driver);
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
