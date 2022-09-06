package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallbackTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"App_appContainer__3jRx1\"]");
        form.$("[type=\"text\"]").setValue("Коркина Света");
        form.$(" [type=\"tel\"]").setValue("+79191234567");
        form.$("[data-test-id=agreement]").click();
        form.$("[type=\"button\"]").click();
        $("[data-test-id=\"order-success\"]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}