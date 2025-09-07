package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); 
    }

    
    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    protected void type(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    protected void scrollToElement(WebElement element) {

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    
    try { 
        Thread.sleep(500); 
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    }

protected void clickWithScroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
        "var element = arguments[0];" +
        "var y = element.getBoundingClientRect().top + window.pageYOffset - 100;" +
        "window.scrollTo({top: y, behavior: 'smooth'});",
        element
    );

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(element));

    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
}
}
