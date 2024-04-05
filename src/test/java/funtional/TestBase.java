package funtional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import utils.Helper;
import utils.OptionsManager;

import java.io.IOException;
import java.time.Duration;

import static utils.Helper.addLogging;
import static utils.Helper.writeOutputData;

public class TestBase {
    public WebDriver driver;
    final String DEFAULT_HEADLESS_VALUE = "";
    final String DEFAULT_BROWSER_VALUE = "";
    final String DEFAULT_INCOGNITO_VALUE = "";
    private boolean RUN_FROM_PROPS_FILE = true;

    StringBuffer stringBuffer = new StringBuffer();

    @BeforeSuite
    public void SetPreReqValues(){

    }

    @BeforeTest
    @Parameters({"browser", "headless", "incognito"})
    public void setupTest(@Optional(DEFAULT_BROWSER_VALUE) String browser,
                          @Optional(DEFAULT_HEADLESS_VALUE) String headless,
                          @Optional(DEFAULT_INCOGNITO_VALUE) String incognito) throws InterruptedException {
        System.out.println("Browser : " + browser);
        System.out.println("Browser : " + headless);
        System.out.println("Browser : " + incognito);

        addLogging(stringBuffer);
        stringBuffer.append("RUN_FROM_PROPS_FILE:" +RUN_FROM_PROPS_FILE + "\n");

        if(!browser.equals("") && !headless.equals("") && !incognito.equals(""))
            RUN_FROM_PROPS_FILE = false;
        Setup(browser,headless, incognito);

    }

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
    public void Setup(String browser, String headless, String incognito) throws InterruptedException {
            if(RUN_FROM_PROPS_FILE){
                boolean isHeadless = Boolean.parseBoolean(Helper.readPropertyByKey("isHeadless"));
                boolean isCognito = Boolean.parseBoolean(Helper.readPropertyByKey("isCognito"));
                if(Helper.readPropertyByKey("browser").toLowerCase().equals("chrome"))
                    driver  = new ChromeDriver(OptionsManager.getChromeOptions(isHeadless,isCognito));
                if(Helper.readPropertyByKey("browser").toLowerCase().equals("firefox"))
                    driver  = new FirefoxDriver();
            }
            else{
                if(browser.equals("chrome")){
                    driver = new ChromeDriver(OptionsManager
                            .getChromeOptions(Boolean.parseBoolean(headless)
                                    ,Boolean.parseBoolean(incognito)));
                }
                else{
                    driver  = new FirefoxDriver();
                }
            }


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
    public void TearDown() throws InterruptedException, IOException {
        writeOutputData(stringBuffer.toString());
        Thread.sleep(3000);
        driver.quit();
    }
}
