package pl.bartoszadamus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(xpath = "//ul[@class = 'woocommerce-error']//li")
    private WebElement error;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;


    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email,password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email,password);
        return this;
    }

    public LoggedUserPage loginValidData(String username,String password) {
        loginUser(username,password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginInvalidData(String username,String password) {
        loginUser(username,password);
        return this;
    }

    private void loginUser(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    private void registerUser(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        registerButton.click();
    }

    public WebElement getError() {
        return error;
    }
}
