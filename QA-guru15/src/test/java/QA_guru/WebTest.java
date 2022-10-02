package QA_guru;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class WebTest {
    @Test
    void yandexSearchTest(){
        open("https://ya.ru/");
        $("#text").setValue("Selenide");
        $("button[type='submit']").click();
        $$("li.serp-item").shouldHave(CollectionCondition.size(10));
    }
    @ParameterizidTest()
}
