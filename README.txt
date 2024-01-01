Automated Testing Framework - Cucumber Selenium
Introduction
This repository contains a simple automated testing framework using Cucumber and Selenium for testing login functionality on a web application. The framework includes page objects, step definitions, and a test runner class.

Project Structure
The project is structured into three main packages:

Pages Package

LoginPage.java: Page object class representing the login page.
ProfilePage.java: Page object class representing the profile page.
Runner Package

TestRunner.java: Cucumber test runner class with configuration options.
Steps Package

StepDefinition.java: Step definition class containing the Cucumber step definitions for the login feature.
Page Objects
LoginPage
java
Copy code
package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends StepDefinition {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // WebElements
    public @FindBy(id = "username") WebElement usernameBox;
    public @FindBy(id = "password") WebElement passwordBox;
    public @FindBy(css = ".fa.fa-2x.fa-sign-in") WebElement loginBtn;
    @FindBy(css = ".flash.error") WebElement flashError;

    // Methods
    public void enterUserName(String username) {
        usernameBox.clear();
        usernameBox.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordBox.clear();
        passwordBox.sendKeys(password);
    }

    public void clickOnLogin() {
        loginBtn.click();
    }
}
ProfilePage
java
Copy code
package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends StepDefinition {

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    // WebElements
    public @FindBy(css = ".icon-2x.icon-signout") WebElement logoutBtn;

    // Methods
    public void clickOnLogout() {
        logoutBtn.click();
    }
}
Test Runner
TestRunner
java
Copy code
package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/login.feature"},
        glue = {"Steps"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
Step Definitions
StepDefinition
java
Copy code
package Steps;

import Pages.LoginPage;
import Pages.ProfilePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefinition {
    public static WebDriver driver;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @When("User inputs username {string}")
    public void userInputsUsername(String username) {
        loginPage.enterUserName(username);
    }

    @And("User inputs password {string}")
    public void userInputsPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLogin();
    }

    @Then("User is logged in")
    public void userIsLoggedIn() {
        Assert.assertTrue(profilePage.logoutBtn.isDisplayed());
    }

    @Then("User is not logged in")
    public void userIsNotLoggedIn() {
        // Add appropriate assertions or actions for user not logged in scenario
    }
}
Getting Started
Clone the repository to your local machine.
Open the project in your preferred Java IDE.
Ensure you have the necessary dependencies installed (Cucumber, Selenium, TestNG).
Run the TestRunner class to execute the test.
Dependencies
Cucumber
Selenium
TestNG
WebDriverManager
Notes
Ensure that the web driver executable (ChromeDriver) is compatible with your browser version.
Modify the login.feature file in the src/test/resources directory to customize test scenarios.
Feel free to extend and modify this framework based on your specific testing requirements.