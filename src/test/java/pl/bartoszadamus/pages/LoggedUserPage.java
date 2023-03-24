package pl.bartoszadamus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {

    @FindBy(xpath = "//p[text()='Hello ']")
    private WebElement entryTitle;

    private WebDriver driver;
    public LoggedUserPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebElement getEntryTitle() {
        return entryTitle;
    }
}
