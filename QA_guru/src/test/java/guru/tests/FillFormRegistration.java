package guru.tests;

import com.codeborne.selenide.Configuration;
import guru.pages.RegistrationFromPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FillFormRegistration {
    RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Disabled
    @Test
    @DisplayName("Положительная проверка формы регистрации, все поля")
    public void positiveTestFormRegistration(){
        registrationFromPage.openMainPage()
                .chooseCountry()
                .inputName("Alex1")
                .chooseAge()
                .inputEmail("asde12rtfghj@gmail.com")
                .inputPassword("birthday12345");
    }

}
