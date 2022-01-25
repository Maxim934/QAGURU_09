package maxim.kim.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static maxim.kim.Tests.TestData.*;

public class FieldsTest extends TestBase {
    @Test
    @DisplayName("Заполненние формы")
    public void fillFields() {
        registrationPage.openPage()
                .fillName(firstName)
                .fillSurname(secondName)
                .chooseGender()
                .fillEmail(email)
                .fillNumber(mobilePhone)
                .setBirthDate(day, month, year)
                .setSubject()
                .setHobbie()
                .uploadImage("src/test/resources/img.png")
                .setAdress(address)
                .chooseStateAndCity();
    }

    @Test
    @DisplayName("Проверка полей")
    public void checkFields() {
        sleep(1000);
        registrationPage.checkResultsValue("Student Name", firstName + " " + secondName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", mobilePhone)
                .checkResultsValue("Date of Birth", day + " " + month + "," + year)
                .checkResultsValue("Picture", "img.png")
                .checkResultsValue("Address", address);
    }

}
