package guru.tests;

import com.codeborne.selenide.Configuration;
import guru.pages.RegistrationFromPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;


public class TestLogIn {
    RegistrationFromPage registrationFromPage = new RegistrationFromPage();
    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    @DisplayName("Позитивная проверка логина")
    public void logInTestPositive(){
        registrationFromPage.openMainPage()
                .clickLogIn()
                .setEmail("johnsmith@simplemail.top")
                .setPass("super-secret123")
                .clickButtonLogIn()
                .checkName();
    }
    @Test
    @DisplayName("Проверка логина с правильной почтой и неправильным паролем")
    public void logInTestNegative(){
        registrationFromPage.openMainPage()
                .clickLogIn()
                .setEmail("johnsmith@simplemail.top")
                .setPass("super-Secret123")
                .clickButtonLogIn()
                .checkName();
    }
    @Test
    @DisplayName("Проверка кнопки Forgot password")
    public void checkPositiveButtonForgotPass(){
        registrationFromPage.openMainPage()
                .clickLogIn()
                .clickButtonLogIn()
                .clickForgotPassword()
                .checkPopApp();
    }
    @Test
    @DisplayName("Позитивная проверка логина и проверка отображения ботов после авторизации")
    public void logInTestCheckBots(){
        registrationFromPage.openMainPage()
                .clickLogIn()
                .setEmail("johnsmith@simplemail.top")
                .setPass("super-secret123")
                .clickButtonLogIn();
        $(".content__box .pure-g").exists();

    }
}
