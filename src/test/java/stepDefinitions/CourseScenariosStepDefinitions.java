package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SignInPage;
import pages.FashionPage;
import pages.CartPage;

import static org.testng.AssertJUnit.assertTrue;

public class CourseScenariosStepDefinitions {
    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private FashionPage fashionPage;
    private CartPage cartPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.open();
    }

    @When("I click on the Account -> Sign in link")
    public void iClickOnSignInLink() {
        signInPage = homePage.clickSignInLink();
    }

    @And("I fill in the registration data with:")
    public void iFillInRegistrationData(String fullName, String email, String password) {
        signInPage.fillRegistrationData(fullName, email, password);
    }

    @And("I submit the registration form")
    public void iSubmitRegistrationForm() {
        signInPage.submitRegistrationForm();
    }

    @And("I login using the email {string} and password {string}")
    public void iLogin(String email, String password) {
        signInPage.login(email, password);
    }

    @And("I hover on Fashion -> Shirts")
    public void iHoverOnFashionShirts() {
        fashionPage = new FashionPage(driver);
        fashionPage.hoverOnFashionShirts();
    }

    @And("I add {int} items to my cart")
    public void iAddItemsToCart(int quantity) {
        fashionPage.addItemsToCart(quantity);
    }

    @And("I increase the item quantity from the cart page")
    public void iIncreaseItemQuantityFromCartPage() {
        cartPage = fashionPage.viewCart();
        cartPage.increaseItemQuantity();
    }

    @Then("the item is added to the cart successfully")
    public void itemIsAddedToCartSuccessfully() {
        assertTrue(cartPage.isItemAddedToCart());
    }

    @And("the subtotal is calculated correctly according to the added item prices")
    public void subtotalIsCalculatedCorrectly() {
        assertTrue(cartPage.isSubtotalCorrect());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

