package pagestests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.WebFormPage;

import java.time.Duration;

@Test
public class WebFormTest {
WebDriver driver=new ChromeDriver();
private  WebFormPage webFormPage;
    public void testWebForm() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        webFormPage=new WebFormPage(driver);
        webFormPage.setTextInput("Mariam");
        webFormPage.setPasswordInput("mariam123");
        webFormPage.setTextAreaInput("This is a sample text");
        webFormPage.selectDropdownList("Two");
        webFormPage.selectDataListElement("Seattle");
        webFormPage.checkButton2();
        webFormPage.checkRadioButton2();
        webFormPage.selectColor("#00ff00");
        webFormPage.selectDate("01/08/2024");
        webFormPage.selectRange();

        webFormPage.submitForm();

        ResultPage resultPage=webFormPage.submitAndNavigateToResultPage();
        String submissionMessage=resultPage.getSubmissionMessage();
        System.out.println("Submission Message: " + submissionMessage);
        Assert.assertEquals(resultPage.getSubmissionMessage(), submissionMessage);




    }

}
