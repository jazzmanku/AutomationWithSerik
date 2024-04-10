package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariOptions;

public class OptionsManager {

    public static ChromeOptions getChromeOptions(boolean isHeadless, boolean isCognito){
        ChromeOptions options = new ChromeOptions();
        if(isHeadless)
            options.addArguments("--headless=new");
            //options.addArguments("--headless");
        if(isCognito)
            options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        //options.setCapability(FirefoxDriver.Capability(), profile);
        return options;
    }

    public static SafariOptions getSafariOptions () {
        SafariOptions options = new SafariOptions();
        return options;
    }

    public static EdgeOptions getEdgeOptions () {
        EdgeOptions options = new EdgeOptions();
        return options;
    }
}
