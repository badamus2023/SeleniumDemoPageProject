package pl.bartoszadamus.test;

import org.testng.annotations.Test;
import pl.bartoszadamus.models.Customer;
import pl.bartoszadamus.pages.HomePage;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkTest() {
        Customer customer = new Customer();
        customer.setFirstName("Bartosz");
        customer.setLastName("Adamus");
        customer.setCountryName("Poland");
        customer.setCompanyName("Unemployed");
        customer.setCity("Andrychow");
        customer.setAddressFirst("Sułkowice");
        customer.setAddressSecond("Centralna");
        customer.setPostCode("34-120");
        customer.setEmail("bartosz.adamus321@gmail.com");
        customer.setPhone("123123123");

        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer,"Some random comment");
        }
    }
