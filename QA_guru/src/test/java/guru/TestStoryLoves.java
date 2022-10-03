package guru;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import guru.data.Locale;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestStoryLoves {
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://storyloves.net/";
        Configuration.browserSize = "1720x1440";
        Configuration.holdBrowserOpen = true;
    }

     static Stream<Arguments> checkFooterStoryLoves(){
        return Stream.of(
                Arguments.of(List.of("Terms of use", "Privacy", "Contact Information", "About us", "Imprint", "Support service"), Locale.CANADA),
                Arguments.of(List.of("Términos de uso", "Privacidad", "Información de contacto", "Quiénes somos", "Imprint", "Support service"),Locale.ESPAÑA));
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
    static Stream<Arguments> checkFooterLinks() {
        return Stream.of(
                Arguments.of(List.of("Términos de uso", "Privacidad", "Información de contacto", "Quiénes somos", "Imprint", "Support service"), Locale.COLOMBIA),
                Arguments.of(List.of("Condizioni di utilizzo", "Privacy", "Informazioni di contatto", "Chi siamo", "Imprint", "Servizio di assistenza"), Locale.ITALIA)
        );
    }

   


}
