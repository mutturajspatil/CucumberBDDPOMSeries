package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    public static WebDriverWait wait;

    // 1. By locators

    private By emailId=By.id("email");
    private By password=By.id("passwd");

    //private By signInButton=By.name("SubmitLogin");

    //private By forgotPwdLink= By.linkText("Forgot your password?");
   private By forgotPwdLink= By.xpath("//a[@title='Recover your forgotten password']");
    //2.  Constructor of the page class

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

//    public void clickOnSignInLink(){
//        driver.findElement(By.linkText("Sign in")).click();
//            }

    public String getLoginPageTitle() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Title of the page is{} "+driver.getTitle());
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist(){
        return driver.findElement(forgotPwdLink).isDisplayed();

    }


    public void enterUserName(String username){
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() throws InterruptedException {
        //driver.findElement(signInButton).click();
        //((JavascriptExecutor)driver).executeScript("arguments[0].click();", signInButton);
       //
//   /html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
      //  Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait = new WebDriverWait( driver, 20);
      //  WebElement signInButton=driver.findElement(By.xpath("//*[@class='icon-lock left']"));

        WebElement signInButton=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();",signInButton);
       // js.executeScript("arguments[0].click();", signInButton);
        //js.executeScript("arguments[0].setAttribute('style','visibility:visible;');",signInButton);
        js.executeScript("arguments[0].style.display='block';", signInButton);
        signInButton.click();
        Thread.sleep(10000);
    }

    public AccountsPage doLogin(String username, String Password) throws InterruptedException {

        System.out.println("login with:"+username+" and " + Password);
        driver.findElement(emailId).sendKeys(username);
        driver.findElement(password).sendKeys(Password);
        wait = new WebDriverWait( driver, 20);
        WebElement signInButton=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();",signInButton);
        js.executeScript("arguments[0].style.display='block';", signInButton);
        Thread.sleep(10000);
        signInButton.click();
        return new AccountsPage(driver);
    }


}
