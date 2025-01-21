package selenuim_dynamic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BoxTest {

    WebDriver driver = new ChromeDriver();
    By adder = new By.ById("adder");
    By reveal = new By.ById("reveal");
    By revealedField = new By.ById("revealed");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    @Test
    public void test(){
    driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

    driver.findElement(adder).click();
    driver.findElement(reveal).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(revealedField));
    driver.findElement(revealedField).sendKeys("Mariam");


    Assert.assertEquals("Mariam", "Mariam");



    }


}
