package com.example.tests;

import com.example.pages.CareersPage;
import com.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import java.lang.InterruptedException;

public class CareersPageTest extends BaseTest {

    @Test
    public void testNavigateToFindYourDreamJob() throws InterruptedException {

    try {
        WebElement acceptButton = driver.findElement(By.xpath("//*[@id='wt-cli-accept-all-btn']"));
        if (acceptButton.isDisplayed()) {
            acceptButton.click();
            System.out.println("Cookie popup kapatıldı");
        }
    } catch (NoSuchElementException e) {
        System.out.println("Cookie popup bulunamadı veya zaten kapalı");
    }
        HomePage homePage = new HomePage(driver);
        homePage.openCompanyDropdown();
        homePage.clickCareersLink();



        CareersPage careersPage = new CareersPage(driver);
        careersPage.clickFindYourDreamJobLink();
        System.out.println("Mevcut URL: " + driver.getCurrentUrl());

        careersPage.selectLocation("/html/body/span/span/span[2]/ul/li[11]");
        careersPage.selectDepartment("/html/body/span/span/span[2]/ul/li[14]");
        System.out.println("Location and Department selected successfully!");

        careersPage.clickViewJobButton();
        System.out.println("Mevcut URL: " + driver.getCurrentUrl());


       
    }
}