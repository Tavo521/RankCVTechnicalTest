package com.google.co.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public void visit(String url){
        driver.get(url);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

}
