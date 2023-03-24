package pl.bartoszadamus.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bartoszadamus.pages.HomePage;

public class registerTest extends BaseTest{

    @Test
    public void registerUserTest() {
        int randomNumber = (int) (Math.random()*1000);
        String email = "test"+randomNumber+"@gmail.com";
        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(email,"test123@gmail.com")
                .getEntryTitle();

        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertTrue(entryTitle.getText().contains("test"));
    }
    @Test
    public void registerWithSameEmailTest(){
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test123@gmail.com","test123@gmail.com")
                .getError();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address. Please log in."));
    }
}
