package pl.bartoszadamus.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bartoszadamus.pages.HomePage;

public class LoginTest extends BaseTest{

    @Test
    public void loginUserTest() {
        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .loginValidData("test123@gmail.com","test123@gmail.com")
                .getEntryTitle();

        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertTrue(entryTitle.getText().contains("test"));
    }

    @Test
    public void loginWithInvalidData(){
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .loginInvalidData("janek123@gmail.com","janek123@gmail.com")
                .getError();
        Assert.assertTrue(error.getText().contains("Incorrect username or password."));
    }
}
