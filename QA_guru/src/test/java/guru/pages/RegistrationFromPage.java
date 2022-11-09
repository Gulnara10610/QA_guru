package guru.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFromPage {
    public RegistrationFromPage openMainPage() {
        open("https://storyloves.net/");
        $("div.registration__item.active").shouldHave(Condition.text("Registration"));
        return this;
    }
    public RegistrationFromPage chooseCountry(){
        $(".flag.flag--arrow.flag--us").click();
        $(".flag.flag--it").click();
        return this;
    }
    public RegistrationFromPage inputName(String value){
        $("input#name").setValue(value);
        return this;
    }
    public RegistrationFromPage chooseAge(){
        $(".selectric-wrapper.selectric-user_age").click();
        $(".mCSB_container li:nth-of-type(3)").click();
        return this;
    }
    public RegistrationFromPage inputEmail(String email){
        $("#email").setValue(email);
        return this;
    }
    public RegistrationFromPage inputPassword(String pass){
        $("#password").setValue(pass).pressEnter();
        return this;
    }
    public RegistrationFromPage clickTerms(){
        $(withText("By pressing")).click();
        return this;
    }
    public RegistrationFromPage clickButtonRegistration(){
        $("button.form__button.button.js_button.js_signup").click();
        return this;
    }
    public RegistrationFromPage checkUserName(){
        $("div.user__name").shouldHave(Condition.text("Alex"));
        return this;
    }
    public RegistrationFromPage clickLogIn(){
        $(".registration__item[data-tabs='2']").click();
        return this;}

     public RegistrationFromPage setEmail(String logIn){
            $("#email[data-enter-login='js_login']").setValue(logIn);
        return this;
    } public RegistrationFromPage setPass(String password){
        $("#password[data-enter-login='js_login']").setValue(password);
        return this;
    }
    public RegistrationFromPage clickButtonLogIn(){
        $("button.form__button.button.js_login").click();
        return this;
    }
    public RegistrationFromPage checkName(){
        $(".user__name").shouldHave(Condition.text("John smith"));
        return this;
    }
    public RegistrationFromPage clickForgotPassword(){
        $(".registration--link.js_popup_forgot_password").click();
        return this;
    }
    public RegistrationFromPage checkPopApp(){
        $("[data-popup-box='1'] .popup__title").shouldHave(Condition.text("Forgot your password?"));
        return this;
    }




}
