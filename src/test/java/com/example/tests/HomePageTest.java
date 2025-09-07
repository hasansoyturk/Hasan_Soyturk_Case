package com.example.tests;

import com.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePageLoads() {
        HomePage homePage = new HomePage(driver);

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://useinsider.com/", currentUrl);

    }


    @Test
    public void testNavigatetoCareersPage() {
        HomePage homePage = new HomePage(driver);
        
        homePage.openCompanyDropdown();
        
        homePage.clickCareersLink();


        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://useinsider.com/careers/", currentUrl);
        
    }


}
