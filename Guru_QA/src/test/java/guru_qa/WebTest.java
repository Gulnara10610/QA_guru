package guru_qa;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {
    @ValueSource(strings ={"Selenide","JUnit"})
//Тестовые данные: ["Selenide","JUnit"]
    //[testData] = (String testData)
    @ParameterizedTest(name = "Проверка числа результатов поиска {0}")
    void yandex(String testData){
        open("https://ya.ru/");
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$(".serp-item").shouldHave(CollectionCondition.size(11))
                .first().shouldHave(text(testData));
    }
    @CsvSource(value = {
            "Selenide", "Selenide - это фреймворк для автоматизированного тестирования",
            "JUnit", "A programmer-oriented testing framework for Java"
    })
    @ParameterizedTest(name = "Проверка числа результатов поиска {0}")
    void yandexSearch(String searchQuery, String expectedText){
        open("https://ya.ru/");
        $("#text").setValue(searchQuery);
        $("button[type='submit']").click();
        $$("li.serp-item")
                .shouldHave(CollectionCondition.size(11))
                .first()
                .shouldHave(text(expectedText));
    }
    static Stream<Arguments>selenideSiteButtonText(){
        return Stream.of(
                Arguments.of(List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"), Locale.EN),
                Arguments.of(List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"), Locale.RU)
        );


    }
    @MethodSource
    @ParameterizedTest(name = "Проверка отображения названия кнопок для локали: {1}")
    void selenideSiteButtonText(Locale locale, List<String> buttonsTexts){
        open("https://selenide.org/");
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a").filter(visible)
                .shouldHave(CollectionCondition.texts(buttonsTexts));
    }
    @MethodSource("selenideSiteButtonsTextDataProvider")
    @ParameterizedTest(name = "Проверка отображения названия кнопок для локали: {1}")
    void selenideSiteButtonsText(List<String> buttonsTexts, Locale locale) {
        open("https://selenide.org/");
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a").filter(visible)
                .shouldHave(CollectionCondition.texts(buttonsTexts));
    }

    @EnumSource(Locale.class)
    @ParameterizedTest
    void checkLocaleTest(Locale locale) {
        open("https://selenide.org/");
        $$("#languages a").find(text(locale.name())).shouldBe(visible);
    }
}
