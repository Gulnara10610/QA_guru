package guru;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import guru.data.Locale;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestStoryLoves {
    public static String softeka = "UAB Softeka 304873072, Saltkalviu g. 64-23, Vilnius, 02175, LITHUANIA,\n" +
            "Landscape Trends LP NL000408 Suite 7030 6 Margaret Street, Newry, County Down, Northern Ireland, BT34 1DF";

    @BeforeAll
    static void openPage(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

     static Stream<Arguments> checkFooterStoryLoves(){

        return Stream.of(
                Arguments.of(List.of("Terms of use", "Privacy", "Contact Information", "About us", "Imprint", "Support service"), Locale.CANADA),
                Arguments.of(List.of("Términos de uso", "Privacidad", "Información de contacto", "Quiénes somos", "Imprint", "Support service"),Locale.ESPAÑA),
                Arguments.of(List.of("Zasady użytkowania", "Prywatność", "Informacje kontaktowe", "O nas", "Imprint", "Obsługa klienta"),Locale.POLSKA),
                Arguments.of(List.of("Términos de uso", "Privacidad", "Información de contacto", "Quiénes somos", "Imprint", "Support service"),Locale.MÉXICO),
                Arguments.of(List.of("Términos de uso", "Privacidad", "Información de contacto", "Quiénes somos", "Imprint", "Support service"),Locale.COLOMBIA),
                Arguments.of(List.of("Condizioni di utilizzo", "Privacy", "Informazioni di contatto", "Chi siamo", "Imprint", "Servizio di assistenza"),Locale.ITALIA),
                Arguments.of(List.of("Terms of use", "Privacy", "Contact Information", "About us", "Imprint", "Support service"),Locale.USA)

        );
    }
    @MethodSource("checkFooterStoryLoves")
    @ParameterizedTest(name = "Проверка подвала на количество ссылок {1}")
    void checkFooterStoryLoves(List<String> footerTexts, Locale locale){
        open("https://storyloves.net/");
        $("div.ccode").click();
        $$("span.flag__text").find(text(locale.name())).click();
        $$("div.footer__list").shouldHave(CollectionCondition.texts(footerTexts));

    }

    @ValueSource(strings = {"cxcvbx@mail.ru","rtfghbvcxz@mail.ru"})
    @ParameterizedTest(name = "проверка авторизации{0}")
        void checkAvtorization(String testData){
        open("https://storyloves.net/");
        $("div.registration__item[data-tabs='2']").click();
        $("input#email[data-enter-login='js_login']").setValue(testData);
        $("input#password[data-enter-login='js_login']").setValue(testData);
        $("button.form__button.button.js_login[type='button']").click();
        $("a[href='/logout']").click();
    }
    static Stream<Arguments> checkFooterStoryLovesText() {
        return Stream.of(
                Arguments.of(List.of("Propiedad literaria © StoryLoves 2022"), Locale.COLOMBIA),
                Arguments.of(List.of("Copyright © StoryLoves 2022"), Locale.ITALIA),
                Arguments.of(List.of("Propiedad literaria © StoryLoves 2022"), Locale.MÉXICO),
                Arguments.of(List.of("Drepturi de autor © StoryLoves 2022"), Locale.Români),
                Arguments.of(List.of("Propiedad literaria © StoryLoves 2022"), Locale.ESPAÑA),
                Arguments.of(List.of("Prawo autorskie © StoryLoves 2022"), Locale.POLSKA),
                Arguments.of(List.of("Copyright © StoryLoves 2022"), Locale.CANADA),
                Arguments.of(List.of("Copyright © StoryLoves 2022"), Locale.USA)
        );
    }
    @MethodSource("checkFooterStoryLovesText")
    @ParameterizedTest(name = "Проверка отображения текста футера для локали: {1}")
    void checkFooterLinks(List<String> aboutCompanyTexts, Locale locale) {
        open("https://storyloves.net/");
        $("div.ccode").click();
        $$("span.flag__text").find(text(locale.name())).click();
        $$(".footer__copyright").shouldHave(CollectionCondition.texts(aboutCompanyTexts));
    }
    static Stream<Arguments> checkFooterStoryLovesTextAboutCompany() {
        return Stream.of(
                Arguments.of(List.of(softeka), Locale.COLOMBIA),
                Arguments.of(List.of(softeka), Locale.ITALIA),
                Arguments.of(List.of(softeka), Locale.MÉXICO),
                Arguments.of(List.of(softeka), Locale.ESPAÑA),
                Arguments.of(List.of(softeka), Locale.POLSKA),
                Arguments.of(List.of(softeka), Locale.CANADA),
                Arguments.of(List.of(softeka), Locale.Români),
                Arguments.of(List.of(softeka), Locale.USA)
                );
    }
    @MethodSource("checkFooterStoryLovesTextAboutCompany")
    @ParameterizedTest(name = "Проверка отображения текста Двух юрюлиц в  футере для локали: {1}")
    void checkFooterStoryLovesTextAboutCompany(List<String> checkAboutCompanyTexts, Locale locale) {
        open("https://storyloves.net/");
        $("div.ccode").click();
        $$("span.flag__text").find(text(locale.name())).click();
        $$(".footer__info").shouldHave(CollectionCondition.texts(checkAboutCompanyTexts));
    }
    @Test
    void clickHrefFooter(){
        open("https://storyloves.net/");
        $("div.footer__list [href='/terms']").click();
        $("h1").shouldHave(text("TERMS OF USE"));
        $(".footer__info").shouldHave(text(softeka));
        $("[href='/policy']").click();
        $("div.pure-c.block-info h1").shouldHave(text("Privacy Policy"));
        $(".footer__info").shouldHave(text(softeka));
        $("[href='/contacts']").click();
        $("div.pure-c.block-info h2").shouldHave(text("Write to us"));
        $(".footer__info").shouldHave(text(softeka));
        $("[href='/about']").click();
        $(".pure-c.block-info ").shouldHave(text("Register and start meeting new people today!"));
        $(".footer__info").shouldHave(text(softeka));
        $("[href='/imprint']").click();
        $(".pure-c h2").shouldHave(text("Contact"));
        $(".footer__info").shouldHave(text(softeka));
        $("[href='/help']").click();
        $(".description").shouldHave(text("FAQ"));
        $(".footer__info").shouldHave(text(softeka));
    }





}
