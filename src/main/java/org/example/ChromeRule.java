package org.example;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeRule extends ExternalResource  {
    private WebDriver webDriver;
    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    protected void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
    }

    @Override
    protected void after() {
        webDriver.quit();
    }
}




