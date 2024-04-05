import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://theautomationtechies.com/web-elements-for-ui-testing/");
        Thread.sleep(3000);
        driver.quit();
    }
}
