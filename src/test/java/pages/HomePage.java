package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.noon.com/egypt-en/");
    }

    public SignInPage clickSignInLink() {
        driver.findElement(By.linkText("Account")).click();
        driver.findElement(By.linkText("Sign in")).click();
        return new SignInPage(driver);
    }
}

