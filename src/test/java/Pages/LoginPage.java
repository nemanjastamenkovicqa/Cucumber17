package Pages;


import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends StepDefinition {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public @FindBy( id = "username") WebElement usernameBox;
    public @FindBy( id = "password") WebElement passwordBox;
    public @FindBy( css = ".fa.fa-2x.fa-sign-in") WebElement loginBtn;

    @FindBy (css = ".flash.error")
    WebElement flashError;

    public void enterUserName(String username){
        usernameBox.clear();
    usernameBox.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordBox.clear();
    passwordBox.sendKeys(password);
    }

    public void clickOnLogin(){
        loginBtn.click();
    }


}
