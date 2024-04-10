package funtional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Helper;
import utils.OptionsManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import static utils.Helper.CreateLog;
import static utils.Helper.WriteLogs;

public class TestBase {
    public static WebDriver driver;
    final String DEFAULT_HEADLESS_VALUE = "";
    final String DEFAULT_BROWSER_VALUE = "";
    final String DEFAULT_INCOGNITO_VALUE = "";
    private boolean RUN_FROM_PROPS_FILE = true;

    public StringBuffer stringBuffer = new StringBuffer();

    public static WebDriver getDriver(){
        return driver;
    }
    @BeforeTest
    @Parameters({"browser", "headless", "incognito"})
    public void setupTest(@Optional(DEFAULT_BROWSER_VALUE) String browser,
                          @Optional(DEFAULT_HEADLESS_VALUE) String headless,
                          @Optional(DEFAULT_INCOGNITO_VALUE) String incognito) throws InterruptedException {
        CreateLog(stringBuffer);
        if(!browser.equals("") && !headless.equals("") && !incognito.equals("")){
            System.out.println("Browser : " + browser);
            System.out.println("Headless : " + headless);
            System.out.println("Incognito : " + incognito);
            RUN_FROM_PROPS_FILE = false;
        }
        stringBuffer.append("RUN_FROM_PROPS_FILE:....:" +RUN_FROM_PROPS_FILE + "\n");
        Setup(browser,headless, incognito);

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
            if(browser.equals("firefox")){
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
        WriteLogs(String.valueOf(stringBuffer));
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterMethod
    public void TakeScreenshotOnFailure(ITestResult result, Method method) {
        stringBuffer.append("Test Name...............:" + method.getName() + "\n");
        stringBuffer.append("Test Pass status........:" + result.isSuccess()+ "\n");
        stringBuffer.append("Total test run time.....:" + (result.getEndMillis() - result.getStartMillis())+ " milliseconds\n");
        String screenshotPath = "";
        if (ITestResult.FAILURE == result.getStatus()) {
            stringBuffer.append("Test Case .........: Status: FAIL" + "\n");
            String testCaseName = result.getName();
            try {
                screenshotPath = Helper.TakeScreenCapture(testCaseName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stringBuffer.append("ScreenShot Saved : " + screenshotPath + "\n");

        }
    }
}
