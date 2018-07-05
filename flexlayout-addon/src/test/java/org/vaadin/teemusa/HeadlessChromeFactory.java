package org.vaadin.teemusa;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.parallel.Browser;
import com.vaadin.testbench.parallel.DefaultBrowserFactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class HeadlessChromeFactory extends DefaultBrowserFactory {

    static {
        // Make sure ChromeDriver is set up.
        ChromeDriverManager.getInstance().setup();
    }

    @Override
    public DesiredCapabilities create(Browser browser, String version,
            Platform platform) {
        DesiredCapabilities capabilities = super.create(browser, version,
                platform);

        if (browser.equals(Browser.CHROME)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }

        return capabilities;
    }
}
