package maxim.kim.Tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;
import static maxim.kim.Tests.TestData.*;

public class FieldsTest extends TestBase {
    @Owner("Maxim")
    @Feature("Заполнение регистрационной формы")
    @Story("Issues")
    @DisplayName("Lambda test")
    @Test
    public void fillFields() {

        step("Открыть страницу", () -> {
            registrationPage.openPage();

        });
        step("Заполнение формы", () -> {
            registrationPage
                    .fillName(firstName)
                    .fillSurname(secondName)
                    .chooseGender()
                    .fillEmail(email)
                    .fillNumber(mobilePhone)
                    .setBirthDate(day, month, year)
                    .setSubject()
                    .setHobbie()
                    .setAdress(address)
                    .chooseStateAndCity();
        });


        step("Проверка полей", () -> {
            registrationPage.checkResultsValue("Student Name", firstName + " " + secondName)
                    .checkResultsValue("Student Email", email)
                    .checkResultsValue("Gender", "Male")
                    .checkResultsValue("Mobile", mobilePhone)
                    .checkResultsValue("Date of Birth", day + " " + month + "," + year)
                    .checkResultsValue("Address", address);

        });
    }


}
