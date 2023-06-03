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

public class MyInfoPage {

    private ButtonPage buttonPage;
    private Questions questions;

    private ListsPages listsPages;


    @FindBy(how = How.NAME, using = "middleName")
    private WebElement txtMiddleName;

    @FindBy(how = How.XPATH, using = "//div//label[text()='Street 1']//..//..//div//input")
    private WebElement txtStreetOne;

    @FindBy(how = How.XPATH, using = "//div//label[text()='Street 2']//..//..//div//input")
    private WebElement txtStreetTwo;

    public MyInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.buttonPage = new ButtonPage(driver);
        this.questions = new Questions(driver);
        this.listsPages = new ListsPages(driver);
    }

    public void updateMyInfo(String middleName, String nationality, String maritalStatus) {
        this.buttonPage.btnMyInfo();
        this.questions.timeSeconds(6);
        this.txtMiddleName.sendKeys(Keys.CLEAR);
        this.txtMiddleName.sendKeys(middleName);
        this.listsPages.listNationality(nationality);
        this.listsPages.listMarital(maritalStatus);
        this.questions.scrollGender();
        this.buttonPage.btnSave();
    }

    public void assertUpdatePersonalDetails(String nationality, String maritalStatus) {
        this.questions.validateSave();
        this.questions.scrollPersonalDetails();
        this.questions.timeSeconds(1);
        this.questions.assertUpdatePersonalDetails(nationality, maritalStatus);
    }

    public void fillOutContactDetails(String streetOne, String country, String streetTwo) {
        this.buttonPage.btnMyInfo();
        this.questions.timeSeconds(1);
        this.buttonPage.btnContactDetails();
        this.questions.timeSeconds(1);
        this.txtStreetOne.sendKeys(streetOne);
        this.questions.timeSeconds(1);
        this.listsPages.listCountry(country);
        this.txtStreetTwo.sendKeys(streetTwo);
        this.questions.scrollPersonalDetails();
        this.buttonPage.btnSave();
    }

    public void validateSave() {
        this.questions.timeSeconds(1);
        this.questions.validateSave();
    }
}
