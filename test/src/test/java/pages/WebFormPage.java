package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebFormPage {
    private static WebElement element = null;
    private WebDriver driver;

    public WebFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setTextInput(String text) {
        driver.findElement(By.id("my-text-id")).sendKeys(text);

    }

    public void setPasswordInput(String text) {
        driver.findElement(By.name("my-password")).sendKeys(text);
    }

    public void setTextAreaInput(String textarea) {
        driver.findElement(By.name("my-textarea")).sendKeys(textarea);
    }

    public void selectDropdownList(String option) {
        Select dropdown = new Select(driver.findElement(By.name("my-select")));
        dropdown.selectByVisibleText(option);
    }

    public void selectDataListElement(String option) {
        driver.findElement(By.name("my-datalist")).sendKeys(option);

    }

    public void checkButton1() {
        element = driver.findElement(By.id("my-check-1"));
        element.click();
    }

    public void checkButton2() {
        driver.findElement(By.id("my-check-2")).click();
    }

    public void checkRadioButton2() {
        driver.findElement(By.id("my-radio-2")).click();
    }

    public void selectColor(String color) {
        driver.findElement(By.name("my-colors")).sendKeys(color);
    }

    public void selectDate(String date) {
        driver.findElement(By.name("my-date")).sendKeys(date);
    }

    public void selectRange() {
        driver.findElement(By.name("my-range")).sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT);
    }

    public void submitForm() {
        driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button")).click();
    }

    public ResultPage submitAndNavigateToResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        return new ResultPage(driver);
    }

}