package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void increaseItemQuantity() {
        driver.findElement(By.cssSelector("button[data-qa='cart-item-quantity-increase']")).click();
    }

    public boolean isItemAddedToCart() {
        return driver.findElement(By.cssSelector("span[data-qa='cart-count-badge']")).getText().equals("2");
    }

    public boolean isSubtotalCorrect() {
        double itemPrice = Double.parseDouble(driver.findElement(By.cssSelector("span[data-qa='cart-item-price']")).getText().substring(1));
        double subtotal = Double.parseDouble(driver.findElement(By.cssSelector("span[data-qa='cart-sub-total']")).getText().substring(1));
        return subtotal == itemPrice * 2;
    }
}

