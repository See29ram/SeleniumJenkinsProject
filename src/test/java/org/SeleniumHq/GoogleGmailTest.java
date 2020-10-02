package org.SeleniumHq;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleGmailTest {


    private WebDriver webDriver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/");
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void launchGoogle() {

        webDriver.findElement(By.name("q")).sendKeys("Selenium using Jenkins");
        webDriver.findElement(By.linkText("Gmail")).click();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit();
    }


}
