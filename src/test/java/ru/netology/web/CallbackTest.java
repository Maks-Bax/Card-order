package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {
    @Test
    public void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $(".form.form_size_m.form_theme_alfa-on-white");
        form.$("[type=\"text\"]").setValue("Коркина Света");
        form.$("  [type=\"tel\"]").setValue("+79191234567");
        form.$(".checkbox__box").click();
        form.$("button").click();
        $("[data-test-id=\"order-success\"]").shouldHave(Condition.exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}