package guru.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import guru.pages.RegistrationFromPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckPageNearby {
    static RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        registrationFromPage.openMainPage()
                .clickLogIn()
                .setEmail("johnsmith@simplemail.top")
                .setPass("super-secret123")
                .clickButtonLogIn();
    }
    @Test
    @DisplayName("Проверка наличия элементов на странице")
    public void checkElements(){
        $(".menu__item.active.svgEl span").shouldHave(Condition.text("Personas en línea"));
        $("a[data-svg='search']").shouldHave(Condition.text("Búsqueda"));
        $("span.svgEl[data-svg='premium_v2']").shouldHave(Condition.text("Premium"));
        $("div.user__name").shouldHave(Condition.text("John smith"));
        $("a.user__novip").shouldHave(Condition.text("Premium"));
        $(".user.site-bar").exists();
        $(".premium.site-bar").exists();
        $(".pagination").exists();
        $(".footer").exists();
    }
}

