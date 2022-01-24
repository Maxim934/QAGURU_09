package maxim.kim.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import maxim.kim.Pages.Components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //locators and elements
    CalendarComponent calendar = new CalendarComponent();
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement formHeader = $(".practice-form-wrapper"),
            nameInput = $("#firstName"),
            surnameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            maleRadioButton = $(byText("Male")),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbieSport = $(byText("Sports")),
            imageUpload = $("#uploadPicture"),
            currentAdressArea = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submit = $("#submit"),
            resultsTable = $(".table-responsive");


    //actions
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formHeader.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage fillName(String value) {
        nameInput.setValue(value);
        return this;
    }

    public RegistrationPage fillSurname(String value) {
        surnameInput.setValue(value);
        return this;
    }

    public RegistrationPage fillEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseGender() {
        maleRadioButton.click();
        return this;
    }

    public RegistrationPage fillNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject() {
        subjectInput.click();
        subjectInput.sendKeys("M");
            $(byText("Maths")).click();
        return this;
    }

    public RegistrationPage setHobbie() {
        hobbieSport.click();
        return this;
    }

    public RegistrationPage uploadImage(String imageName) {
        File img = new File(imageName);
        imageUpload.uploadFile(img);
        return this;
    }

    public RegistrationPage setAdress(String address) {
        currentAdressArea.setValue(address);
        return this;
    }

    public RegistrationPage chooseStateAndCity() {
        stateInput.click();
        $(byText("NCR")).click();
        cityInput.click();
        $(byText("Delhi")).click();
        submit.click();
        return this;

    }


    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
