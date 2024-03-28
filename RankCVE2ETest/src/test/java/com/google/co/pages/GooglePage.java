package com.google.co.pages;

import com.google.co.base.Base;
import org.openqa.selenium.*;

public class GooglePage extends Base {

    By gumtreeLocator = By.xpath("//h3[(text()='Used Cars for Sale in London | Great Local Deals')]");

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void search() {
        WebElement searchBox = findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Cars at London");
        searchBox.submit();
    }

    public void joinPage() {
        click(gumtreeLocator);
    }

    public void scrollDown(WebDriver driver) throws InterruptedException {
        for(int i = 1; i <= 3; i++){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(3000);
        }


    }

    public String getTitle(WebDriver driver){
        return driver.getTitle();
    }

}
