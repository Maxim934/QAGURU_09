package maxim.kim.Tests;

import com.codeborne.selenide.Configuration;
import maxim.kim.Pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void config() {
        Configuration.startMaximized = true;
        Configuration.remote = "http://65.108.161.82:4444/wd/hub/";

    }

}
