package OrangeHrm.Steps;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListsPages {

    private WebDriver driver;
    private Questions questions;

    public ListsPages(WebDriver driver) {
        this.driver = driver;
        this.questions = new Questions(driver);
    }

    public void listNationality(String nationality){
        WebElement list = driver.findElement(By.xpath("//div//label[text()='Nationality']//..//..//div//i"));
        list.click();

        WebElement listsNationality = list.findElement(By.xpath("//*[text()='"+nationality+"']"));
        listsNationality.click();
    }

    public void listMarital(String maritalStatus){
        WebElement list = driver.findElement(By.xpath("//div//label[text()='Marital Status']//..//..//div//i"));
        list.click();

        WebElement listsMarital = list.findElement(By.xpath("//*[text()='"+maritalStatus+"']"));
        listsMarital.click();
    }

    public void listCountry(String country){
        WebElement list = driver.findElement(By.xpath("//div//label[text()='Country']//..//..//div//i"));
        list.click();

        WebElement listsCountry = list.findElement(By.xpath("//*[text()='"+country+"']"));
        listsCountry.click();
    }

    public void listRole(String rol){
        WebElement list = driver.findElement(By.xpath("//div//label[text()='User Role']//..//..//div//i"));
        list.click();

        WebElement listsRol = list.findElement(By.xpath("//*[text()='"+rol+"']"));
        this.questions.timeSeconds(2);
        listsRol.click();
    }

    public void listStatus(String status){
        WebElement list = driver.findElement(By.xpath("//div//label[text()='Status']//                                                                                                                                              ..//..//div//i"));
        list.click();

        WebElement listsStatus = list.findElement(By.xpath("//*[text()='"+status+"']"));
        this.questions.timeSeconds(2);
        listsStatus.click();
    }

}
