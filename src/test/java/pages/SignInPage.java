package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationData(String fullName, String email, String password) {
        driver.findElement(By.id("fullName")).sendKeys(fullName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void submitRegistrationForm() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public void login(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}

