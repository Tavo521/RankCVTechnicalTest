package com.google.co.tests;

import com.google.co.pages.GooglePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class GoogleTest {
    private WebDriver driver;

    GooglePage googlePage;
    @BeforeEach
    public void setUp() {

        googlePage = new GooglePage(driver);
        driver = googlePage.chromeDriverConnection();
        driver.manage().window().maximize();
        googlePage.visit("https://www.google.com/");

    }

    @Test
    void test() throws InterruptedException {
        googlePage.search();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        googlePage.joinPage();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}
