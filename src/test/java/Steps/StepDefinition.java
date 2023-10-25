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
    public void SetUp(){
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
    public void userInputsUsername(String username){
    loginPage.enterUserName(username);
    }
    @And("User inputs password {string}")
    public void userInputsPassword(String password){
    loginPage.enterPassword(password);
    }
    @And("User clicks on Login button")
    public void userClicksOnLoginButton(){
    userClicksOnLoginButton();
    }
    @Then("User is logged in")
    public void userIsLoggedIn(){
     Assert.assertTrue(profilePage.logoutBtn.isDisplayed());
    }
    @Then("User is not loged in")
    public  void nesto(){}
}
