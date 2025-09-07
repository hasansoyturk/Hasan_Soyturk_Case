package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "#navbarNavDropdown > ul:nth-child(1) > li:nth-child(6)")
    private WebElement companyMenu;


    @FindBy(xpath = "//a[@class='dropdown-sub' and @href='https://useinsider.com/careers/']")
    private WebElement careersLink;


    public void openCompanyDropdown() {
        click(companyMenu);
    }

    public void clickCareersLink() {
        click(careersLink);
    }
}
