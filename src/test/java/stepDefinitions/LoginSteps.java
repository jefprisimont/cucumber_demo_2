package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("I enter invalid username and valid password")
    public void i_enter_invalid_username_and_valid_password() {
        loginPage.enterUsername("invalid");
        loginPage.enterPassword("secret_sauce");
    }

    @When("I leave username and password fields empty")
    public void i_leave_username_and_password_fields_empty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_the_products_page() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
        driver.close();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Epic sadface"));
        driver.close();
    }
}
