package com.google.co.pages;

import com.google.co.base.Base;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends Base {


    By gumtreeLocator = By.xpath("//h3[(text()='Used Cars for Sale in London | Great Local Deals')]");
    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void search(){
        WebElement searchBox = findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Cars at London");
        searchBox.submit();
    }

    public void joinPage(){
        click(gumtreeLocator);
    }

}
