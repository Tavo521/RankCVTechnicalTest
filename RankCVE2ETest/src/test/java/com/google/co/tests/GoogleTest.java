package com.google.co.tests;

import com.google.co.pages.GooglePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        googlePage.scrollDown(driver);
        googlePage.joinPage();
        assertEquals("Used Cars for Sale in London | Great Local Deals | Gumtree", googlePage.getTitle(driver));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}
