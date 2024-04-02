package stepdefinitions;

import com.pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {

        DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        //loginPage.clickOnSignInLink();
        Thread.sleep(3000);
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() throws InterruptedException {
        title = loginPage.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUserName(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) throws InterruptedException {
        loginPage.enterPassword(password);
        Thread.sleep(10000);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        loginPage.clickOnLogin();
    }

}
