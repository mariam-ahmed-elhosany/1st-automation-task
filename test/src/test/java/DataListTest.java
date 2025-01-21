import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DataListTest {
    //bonus

        By txtField1 =new By.ById("my-text-id");
        By txtField2 =new By.ByName("my-password");
        By txtFiekd3 =new By.ByName("my-textarea");
//        By submitmsg= new By.ByXPath("/html/body/main/div/form/div/div[2]/button");
//        By recieve=new By.ById("message");

        @Test
        public void testApp() {

            WebDriver webDriver = new ChromeDriver();
//        WebElement element=webDriver.findElement(By.name("my-select"));

            webDriver.get("https://www.selenium.dev/selenium/web/web-form.html");
            webDriver.findElement(txtField1).sendKeys("Mariam");
            webDriver.findElement(txtField2).sendKeys("Mariam123");
            webDriver.findElement(txtFiekd3).sendKeys("This is a sample text");
            Select select=new Select(webDriver.findElement(new By.ByName("my-select")));
            select.selectByVisibleText("Two");

            WebElement input = webDriver.findElement(By.name("my-datalist")); // Replace with correct input name
            input.click();
//            List<WebElement> options = webDriver.findElements(By.id("my-options"));
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            List<WebElement> options = (List<WebElement>) js.executeScript(
                    "return Array.from(document.querySelector('datalist#my-options').options);"
            );
            // Print and select an option
            for (WebElement option : options) {
                String optionValue = option.getAttribute("value");
                System.out.println("Option: " + optionValue);

                // Select "Seattle" if it matches
                if ("Seattle".equals(optionValue)) {
                    input.sendKeys(optionValue);
                    break;
                }
            }
            String selectedValue = input.getAttribute("value");
            System.out.println("Selected value: " + selectedValue);
            Assert.assertEquals(selectedValue, "Seattle");


        }



}
