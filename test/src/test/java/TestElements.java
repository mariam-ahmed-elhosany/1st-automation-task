import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestElements {
    By inputs=new By.ByLinkText("Inputs");
    By shiftingContent=new By.ByLinkText("Shifting Content");
    By menuElement=new By.ByXPath("//*[@id=\"content\"]/div/a[1]");
    public void testMethod(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(shiftingContent).click();
        driver.findElement(menuElement).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"content\"]/div/ul")));
        List<WebElement> lists=driver.findElements(By.xpath("//*[@id=\"content\"]/div/ul"));
        System.out.println("Total number of lists: " + lists.size());
        for (WebElement element : lists) {
            System.out.print("List Text: " );
            System.out.println(element.getText());
            System.out.println("Number of list items: " + element.findElements(By.tagName("li")).size());
        }

    }
    public static void main(String[] args) {
        TestElements testElements = new TestElements();
        testElements.testMethod();
    }
}

//        driver.findElement(inputs).click();

//        List<WebElement> inputsLink=driver.findElements(By.tagName("input"));
//        for (WebElement input : inputsLink) {
//            System.out.println("Input type: " + input.getAttribute("type"));
//        }
//        List<WebElement>links = driver.findElements(By.tagName("a"));
//        System.out.println("Total number of links: " + links.size());
//        for (WebElement link : links) {
//            String linkText = link.getText().trim(); // Use trim() to remove extra spaces
//            if (!linkText.isEmpty()) { // Ignore links with no visible text
//                System.out.println("Link Text: " + linkText);
//            }

//        }