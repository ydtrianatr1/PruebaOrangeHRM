package OrangeHrm.Definitions;

import OrangeHrm.Pages.AdminPage;
import OrangeHrm.Pages.LoginPage;
import OrangeHrm.Pages.MyInfoPage;
import OrangeHrm.Pages.PimPage;
import OrangeHrm.Steps.Questions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import OrangeHrm.Steps.Conexion;
import io.cucumber.java.en.Given;

public class DefinitionsSteps {

    private WebDriver driver;
    private Conexion conexion = new Conexion();
    private LoginPage loginPage = new LoginPage(driver);
    private PimPage pimPage = new PimPage(driver);
    private MyInfoPage myInfoPage = new MyInfoPage(driver);
    private AdminPage adminPage = new AdminPage(driver);
    private Questions questions = new Questions(driver);

    @Given("^the user open brower$")
    public void open_brower() {
        this.conexion = new Conexion();
        this.driver = this.conexion.openBrower();
    }
    @Given("^the user close brower$")
    public void close_brower() {
        this.questions = new Questions(driver);
        this.questions.closeBrower();
    }

    @When("^the user fill out user (.*) password (.*)$")
    public void fillOutLogin(String user, String password) {
        this.loginPage = new LoginPage(driver);
        this.loginPage.fillOutLogin(user, password);
    }

    @When("^the user select add employee and fill out first name (.*) last name (.*)$")
    public void fillOutAddEmployee(String firstName, String lastName) {
        this.pimPage = new PimPage(driver);
        this.pimPage.optionAddEmployee();
        this.pimPage.fillOutAddEmployee(firstName, lastName);
    }

    @When("^the user updates my information personal detail middle (.*) nationality (.*) marital status (.*)$")
    public void updatePersonalDetails(String middleName, String nationality, String maritalStatus) {
        this.myInfoPage = new MyInfoPage(driver);
        this.myInfoPage.updateMyInfo(middleName, nationality, maritalStatus);
    }

    @Then("^the user validate page Dashboard$")
    public void validateDashboard() {
        this.loginPage = new LoginPage(driver);
        this.loginPage.validateDashboard();

    }

    @Then("^the user validate new employee (.*) (.*)$")
    public void validateUserNew(String firstName, String lastName) {
        this.pimPage = new PimPage(driver);
        this.pimPage.validateUserNew(firstName, lastName);
    }

    @Then("^the user validate update field (.*) (.*)$")
    public void validateUpdateField(String nationality, String maritalStatus) {
        this.myInfoPage = new MyInfoPage(driver);
        this.myInfoPage.assertUpdatePersonalDetails(nationality, maritalStatus);
    }

    @When("^the user fill out contact details (.*) country (.*) street (.*)$")
    public void fillOutContactDetails(String streetOne, String country, String streetTwo) {
        this.myInfoPage = new MyInfoPage(driver);
        this.myInfoPage.fillOutContactDetails(streetOne, country, streetTwo);
    }

    @Then("^the user validate save information contact details$")
    public void validateSave() {
        this.myInfoPage = new MyInfoPage(driver);
        this.myInfoPage.validateSave();
    }

    @When("^the user select option admin and new user$")
    public void optionNewUser() {
        this.adminPage = new AdminPage(driver);
        this.adminPage.optionNewUser();
    }

    @When("^the user fill out (.*) rol (.*) status (.*) user (.*) password (.*) confirm (.*)$")
    public void addUser(String employee, String rol, String status, String userName, String pass, String confirmPass) {
        this.adminPage = new AdminPage(driver);
        this.adminPage.addUser(employee, rol, status,userName,pass, confirmPass);
        this.conexion = new Conexion();

    }
}