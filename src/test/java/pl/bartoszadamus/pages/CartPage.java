package pl.bartoszadamus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement proceedToCheckoutButton;


    private WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public CheckoutDetails openAddressDetails() {
        proceedToCheckoutButton.click();
        return new CheckoutDetails(driver);
    }
}
