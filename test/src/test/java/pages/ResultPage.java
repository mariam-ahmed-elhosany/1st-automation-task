package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
    private WebDriver driver;
    private By receive= By.id("message");
    public ResultPage(WebDriver driver){
        this.driver=driver;
    }
    public String getSubmissionMessage(){
        WebElement element=driver.findElement(receive);
        return element.getText();
    }


}
