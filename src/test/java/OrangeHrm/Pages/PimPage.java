package OrangeHrm.Pages;

import OrangeHrm.Steps.ButtonPage;
import OrangeHrm.Steps.Questions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PimPage {

    private ButtonPage buttonPage;
    private Questions questions;

    @FindBy(how = How.NAME, using = "firstName")
    private WebElement txtFirstName;

    @FindBy(how = How.NAME, using = "lastName")
    private WebElement txtLastName;

    public PimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.buttonPage = new ButtonPage(driver);
        this.questions = new Questions(driver);
    }

    public void optionAddEmployee() {
        this.buttonPage.btnPim();
        this.buttonPage.btnAdd();
    }

    public void fillOutAddEmployee(String firstName, String lastName) {
        this.questions.timeSeconds(1);
        this.txtFirstName.sendKeys(firstName);
        this.txtLastName.sendKeys(lastName);
        this.buttonPage.btnSave();
    }

    public void validateUserNew(String firstName, String lastName) {
        this.questions.timeSeconds(6);
        this.questions.assertValidateUser(firstName, lastName);
    }
}
