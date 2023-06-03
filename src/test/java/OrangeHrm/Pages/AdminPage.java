package OrangeHrm.Pages;

import OrangeHrm.Steps.ButtonPage;
import OrangeHrm.Steps.Conexion;
import OrangeHrm.Steps.ListsPages;
import OrangeHrm.Steps.Questions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    private ButtonPage buttonPage;
    private ListsPages listsPages;
    private Questions questions;


    @FindBy(how = How.XPATH, using = "//label[text()='Employee Name']//..//..//input")
    private WebElement txtEmployee;

    @FindBy(how = How.XPATH, using = "//label[text()='Username']//..//..//input")
    private WebElement txtUserName;

    @FindBy(how = How.XPATH, using = "//label[text()='Password']//..//..//input")
    private WebElement txtPass;


    @FindBy(how = How.XPATH, using = "//label[text()='Confirm Password']//..//..//input")
    private WebElement txtConfirmPass;

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.buttonPage = new ButtonPage(driver);
        this.listsPages = new ListsPages(driver);
        this.questions = new Questions(driver);

    }

    public void optionNewUser() {
        this.buttonPage.btnAdmin();
        this.buttonPage.btnAdd();
    }

    public void addUser(String employee, String rol, String status, String userName, String pass, String confirmPass) {
        this.questions.timeSeconds(2);
        this.txtEmployee.sendKeys(employee);
        this.questions.timeSeconds(3);
        this.txtEmployee.sendKeys(Keys.ARROW_UP);
        this.txtEmployee.sendKeys(Keys.ENTER);
        this.listsPages.listRole(rol);
        this.listsPages.listStatus(status);
        this.txtUserName.sendKeys(userName);
        this.questions.timeSeconds(1);
        this.txtPass.sendKeys(pass);
        this.questions.timeSeconds(1);
        this.txtConfirmPass.sendKeys(confirmPass);
        this.buttonPage.btnSave();
    }

    public void validateSave() {
        this.questions.timeSeconds(1);
        this.questions.validateSave();
    }
}
