import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppClass {



    By txtField1 =new By.ById("my-text-id");
    By txtField2 =new By.ByName("my-password");
    By txtField3 =new By.ByName("my-textarea");
    By submitBtn= new By.ByXPath("/html/body/main/div/form/div/div[2]/button");
    By receive =new By.ById("message");
    By ckeckBtn1 =new By.ById("my-check-1");
    By ckeckBtn2=new By.ById("my-check-2");
    By defaultRadioButton=new By.ById("my-radio-2");
    By checkedRadioButton=new By.ById("my-radio-1");
    By datePicker=new  By.ByName("my-date");
    By colorPicker=new By.ByName("my-colors");
    By range = new By.ByName("my-range");

    @Test
    public void testApp() {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.selenium.dev/selenium/web/web-form.html");
        webDriver.findElement(txtField1).sendKeys("Mariam");
        webDriver.findElement(txtField2).sendKeys("Mariam123");
        webDriver.findElement(txtField3).sendKeys("This is a sample text");
        Select select=new Select(webDriver.findElement(new By.ByName("my-select")));
        select.selectByVisibleText("Two");
        webDriver.findElement(new By.ByName("my-datalist")).sendKeys("Seattle");
        webDriver.findElement(ckeckBtn1).sendKeys(Keys.ARROW_RIGHT);
        webDriver.findElement(ckeckBtn2).click();
        webDriver.findElement(checkedRadioButton).click();
        webDriver.findElement(defaultRadioButton).click();
        webDriver.findElement(datePicker).sendKeys("01/08/2024");
        webDriver.findElement(colorPicker).sendKeys("#00ff00");
        webDriver.findElement(range).sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT);
        webDriver.findElement(submitBtn).click();


        String submit=webDriver.findElement(receive).getText();
        Assert.assertEquals(submit,"Received!");
    }
}
