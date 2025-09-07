package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;  
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.lang.InterruptedException;

public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id='page-head']/div/div/div[1]/div/div/a")
    private WebElement findYourDreamJobLink;


    public void clickFindYourDreamJobLink() throws InterruptedException {
        click(findYourDreamJobLink);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Mevcut URL: " + currentUrl);
    }


    @FindBy(xpath= "//*[@id='top-filter-form']/div[1]/span/span[1]/span")
    private WebElement locationDropdownContainer;


    public void clickLocationDropdownContainer() {
        click(locationDropdownContainer);
    }


    @FindBy(xpath= "//*[@id='select2-filter-by-location-result-ithe-Istanbul, Turkiye']")
    private WebElement locationDropdown;

    public void selectLocation(String locationXpath) throws InterruptedException {
        Thread.sleep(10000); 
        click(locationDropdownContainer);
        Thread.sleep(2000);
        
        ((JavascriptExecutor) driver).executeScript(
            "var dropdown = document.querySelector('.select2-results__options'); " +
            "dropdown.scrollTop += 200;");
        Thread.sleep(1000);
    
            WebElement option = driver.findElement(By.xpath(locationXpath));
            if (option.isDisplayed()) {
                option.click();
            }
    }

    @FindBy(xpath= "//*[@id='top-filter-form']/div[2]/span/span[1]/span")
    private WebElement departmentDropdownContainer;

    @FindBy(xpath= "//*[@id='select2-filter-by-department-result-e4s5-Quality Assurance']")
    private WebElement departmentDropdown;

    public void selectDepartment(String departmentXpath) throws InterruptedException {
        Thread.sleep(3000);
        click(departmentDropdownContainer);
        Thread.sleep(2000);

              ((JavascriptExecutor) driver).executeScript(
            "var dropdown = document.querySelector('.select2-results__options'); " +
            "dropdown.scrollTop += 300;");
            Thread.sleep(1000);
    
            WebElement option = driver.findElement(By.xpath(departmentXpath));
            if (option.isDisplayed()) {
                option.click();
            }
    }

   @FindBy(xpath= "/html/body/section[3]/div/div/div[2]/div[2]")
    private WebElement jobHoverButton;

   public void clickViewJobButton() throws InterruptedException {
    Thread.sleep(5000);

    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", jobHoverButton
    );

    WebElement viewRoleLink = driver.findElement(By.xpath("/html/body/section[3]/div/div/div[2]/div[2]/div/a"));

    Actions actions = new Actions(driver);
    WebElement jobHoverButton = driver.findElement(By.xpath("/html/body/section[3]/div/div/div[2]/div[2]"));
    actions.moveToElement(jobHoverButton).perform();
    actions.moveToElement(viewRoleLink).click().perform();

    for (String handle : driver.getWindowHandles()) {
    driver.switchTo().window(handle); 

    Thread.sleep(5000);
}
    
   }

}
