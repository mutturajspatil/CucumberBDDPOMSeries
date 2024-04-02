package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;

    public static WebDriverWait wait;

    // 1. By locators

    private By accountSections=By.cssSelector("div#center_column span");

    //2.  Constructor of the page claass

    public AccountsPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public int getAccountsSectionCount() throws InterruptedException {
       return(driver.findElements((accountSections)).size());
    }

    public String getAccountsPageTitle()  {
        return(driver.getTitle());
    }

    public List<String> getAccountsSectionsList(){

        List<String> accountsList= new ArrayList<>();
        List<WebElement> accountsHeaderList=driver.findElements(accountSections);

        for(WebElement e : accountsHeaderList){

            String text=e.getText();
            System.out.println(text);
            accountsList.add(text);
        }
        return accountsList;


    }

}
