package OrangeHrm.Steps;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.junit.Assert;

import com.ibm.icu.text.SimpleDateFormat;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Questions {

    @FindBy(how = How.XPATH, using = "]")
    private WebElement navOpcion;
    private WebDriver driver;

    public Questions(WebDriver driver) {
        this.driver = driver;
    }

    public void timeSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validateDashboard() {
        String dashboard = driver.findElement(By.xpath("//span//h6")).getText();
        Assert.assertEquals(dashboard, "Dashboard");


    }

    public void scrollGender() {
        WebElement btnGender = driver.findElement(By.xpath("//label[text() ='Gender']"));
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("arguments[0].scrollIntoView(true)", btnGender);

    }

    public void assertValidateUser(String firstName, String lastName) {
        String employee = driver.findElement(By.xpath("//div[@class = 'orangehrm-edit-employee-name']//h6")).getText();
        Assert.assertEquals(employee, firstName + " " + lastName);
    }

    public void assertUpdatePersonalDetails(String nationality, String maritalStatus) {
        String nationalityGet = driver.findElement(By.xpath("//div//label[text()='Nationality']//..//..//div//div//div/div")).getText();

        Assert.assertEquals(nationalityGet, nationality);

        String maritalGet = driver.findElement(By.xpath("//div//label[text()='Marital Status']//..//..//div//div//div/div")).getText();

        Assert.assertEquals(maritalGet, maritalStatus);
    }

    public void scrollPersonalDetails() {
        WebElement texPersonal = driver.findElement(By.xpath("//div[@class = 'orangehrm-edit-employee-content']"));
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("arguments[0].scrollIntoView(true)", texPersonal);

    }

    public void validateSave(){
        String toast = driver.findElement(By.xpath("//div[@id= 'oxd-toaster_1']//*[text()= 'Success' ]")).getText();
        Assert.assertEquals(toast, "Success");
    }

    public void closeBrower() {
        driver.close();
    }
}