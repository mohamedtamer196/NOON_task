package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FashionPage {
    private WebDriver driver;

    public FashionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOnFashionShirts() {
        WebElement fashionMenu = driver.findElement(By.linkText("Fashion"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fashionMenu).perform();
        driver.findElement(By.linkText("Shirts")).click();
    }

    public void addItemsToCart(int quantity) {
        for (int i = 0; i < quantity; i++) {
            driver.findElement(By.cssSelector("button[data-qa='product']")).click();
            driver.findElement(By.cssSelector("button[data-qa='pdp-add-to-cart-button']")).click();
        }
    }

    public CartPage viewCart() {
        driver.findElement(By.linkText("Cart")).click();
        return new CartPage(driver);
    }
}

