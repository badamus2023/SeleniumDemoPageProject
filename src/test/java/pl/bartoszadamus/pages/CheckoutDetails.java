package pl.bartoszadamus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.bartoszadamus.models.Customer;

public class CheckoutDetails {

    @FindBy(name ="billing_first_name")
    private WebElement billingFirstNameInput;

    @FindBy(name="billing_last_name")
    private WebElement billingLastNameInput;

    @FindBy(name = "billing_company")
    private WebElement billingCompanyInput;

    @FindBy(id = "billing_country")
    private WebElement billingCountryContainer;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressInput;

    @FindBy(id = "billing_address_2")
    private WebElement billingAddressSecondInput;

    @FindBy(id = "billing_postcode")
    private WebElement billingPostCodeInput;

    @FindBy(id = "billing_city")
    private WebElement billingCityInput;

    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;

    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;

    @FindBy(id = "order_comments")
    private WebElement orderCommentsInput;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    private WebDriver driver;

    public CheckoutDetails(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public OrderDetails fillAddressDetails(Customer customer,String comments) {
        billingFirstNameInput.sendKeys(customer.getFirstName());
        billingLastNameInput.sendKeys(customer.getLastName());
        billingCompanyInput.sendKeys(customer.getCompanyName());
        Select countrySelect = new Select(billingCountryContainer);
        countrySelect.selectByVisibleText(customer.getCountryName());
        billingAddressInput.sendKeys(customer.getAddressFirst());
        billingAddressSecondInput.sendKeys(customer.getAddressSecond());
        billingPostCodeInput.sendKeys(customer.getPostCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        orderCommentsInput.sendKeys(comments);
        placeOrderButton.click();
        return new OrderDetails(driver);
    }
}
