package ru.alfabank.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.alfabank.lifecycle.WebTestLifeCycleExtension;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
@ExtendWith(WebTestLifeCycleExtension.class)
public class DebitCardsPageTests {

    @Test
    @Feature("Загрузка страницы")
    @Story("Проверка загрузки заголовка страницы")
    @DisplayName("Debit cards page should be loaded")
    void debitCardsPageHeaderTest() {
        step("Открыть страницу дебетовых карт", () -> {
            open("everyday/debit-cards/");
        });
        step("Проверить заголовок страницы дебетовых карт", () -> {
            $("h1").shouldHave(text("Дебетовые карты"));
        });
    }

    @Test
    @Feature("Загрузка страницы")
    @Story("Проверка загрузки блока  дебетовых карт")
    @DisplayName("Debit cards page should be loaded")
    void debitCardBlocksLoadedTest() {
        step("Открыть страницу дебетовых карт", () -> {
            open("everyday/debit-cards/");
        });
        step("Проверить количества дебетовых карт на странице", () -> {
            $$("#all-cards h2").shouldHaveSize(12);
        });
        step("Проверить корректность загруженных карт", () -> {
            $("#alfacard-benefit h2").shouldHave(text("Альфа-Карта"));
            $("#alfacard-premium h2").shouldHave(text("Альфа-Карта Premium"));
            $("#alfa-travel h2").shouldHave(text("Alfa Travel"));
            $("#alfa-travel-premium h2").shouldHave(text("Alfa Travel Premium"));
            $("#aeroflot h2").shouldHave(text("Аэрофлот"));
            $("#aeroflot-premium h2").shouldHave(text("Аэрофлот Black Edition"));
            $("#yandex h2").shouldHave(text("Яндекс.Плюс"));
            $("#pyaterochka h2").shouldHave(text("Пятёрочка"));
            $("#perekrestok h2").shouldHave(text("Перекрёсток"));
            $("#mir h2").shouldHave(text("МИР"));
            $("#childcard h2").shouldHave(text("Детская карта"));
        });
    }

    @Test
    @Feature("Ссылка на страницу архивных карт")
    @Story("Переход по ссылке")
    @DisplayName("Check archive cards link")
    void archiveCardsLinkTest() {
        step("Открыть страницу дебетовых карт", () -> {
            open("everyday/debit-cards/");
        });
        step("Нажать на ссылку Архивные карты", () -> {
            $("#archive-link a").shouldHave(href("/everyday/debit-cards-archive/"));
            $("#archive-link").$(byText("Архивные карты")).click();
        });
        step("Проверить переход по ссылке в архивные карты", () -> {
            $("h1").shouldHave(text("Архивные карты"));
        });
    }

    @Test
    @Feature("Загрузка страницы")
    @Story("Проверка загрузки блока страхования")
    @DisplayName("Benefits block should be loaded")
    void benefitsBlockLoadedTest() {
        step("Открыть страницу дебетовых карт", () -> {
            open("everyday/debit-cards/");
        });
        step("Проверка загрузки блока страхования", () -> {
            $("#benefit h3").shouldHave(text("Все деньги застрахованы"));
        });
    }

    @Test
    @Feature("Загрузка страницы")
    @Story("Проверка загрузки блока SEO")
    @DisplayName("SEO block should be loaded")
    void seoBlockLoadedTest() {
        step("Открыть страницу дебетовых карт", () -> {
            open("everyday/debit-cards/");
        });
        step("Проверка загрузки блока SEO", () -> {
            $("#seo-text").shouldBe(visible);
        });
    }

    @Test
    @Feature("Фильтрация карт")
    @Story("Фильтрация по Premium")
    @DisplayName("Check Premium filter")
    void premiumFilterTest() {
        step("Открыть страницу дебетовых карт", () -> {
            open("everyday/debit-cards/");
        });
        step("Нажать на пункт фильтра Premium ", () -> {
            $("[data-test-id=tabs-list-tabTitle-1]").click();
        });
        step("Проверить количество и заголовки отфильтрованных карт", () -> {
            $$("#premium-cards h2").shouldHaveSize(3);
            $("#alfacard-premium h2").shouldHave(text("Альфа-Карта Premium"));
            $("#alfa-travel-premium h2").shouldHave(text("Alfa Travel Premium"));
            $("#aeroflot-premium h2").shouldHave(text("Аэрофлот Black Edition"));
        });
    }

    @Test
    @Feature("Фильтрация карт")
    @Story("Фильтрация для путешествия ")
    @DisplayName("Check trip filter")
    void tripFilterTest() {
        step("Открыть страницу дебетовых карт", () -> {
            open("everyday/debit-cards/");
        });
        step("Нажать на пункт Для путешествий", () -> {
            $("[data-test-id=tabs-list-tabTitle-2]").click();
        });
        step("Проверить количество и заголовки отфильтрованных карт", () -> {
            $$("#travel-cards h2").shouldHaveSize(4);
            $("#alfa-travel h2").shouldHave(text("Alfa Travel"));
            $("#alfa-travel-premium h2").shouldHave(text("Alfa Travel Premium"));
            $("#aeroflot h2").shouldHave(text("Аэрофлот"));
            $("#aeroflot-premium h2").shouldHave(text("Аэрофлот Black Edition"));
        });
    }

    @Test
    @Feature("Фильтрация карт")
    @Story("Фильтрация для покупок")
    @DisplayName("Check shopping filter")
    void shoppingFilterTest() {
        step("Открыть страницу дебетовых карт", () -> {
            open("everyday/debit-cards/");
        });
        step("Нажать на пункт Для покупок", () -> {
            $("[data-test-id=tabs-list-tabTitle-3]").click();
        });
        step("Проверить количество и заголовки отфильтрованных карт", () -> {
            $$("#shopping-cards h2").shouldHaveSize(4);
            $("#alfacard-benefit h2").shouldHave(text("Альфа-Карта"));
            $("#yandex h2").shouldHave(text("Яндекс.Плюс"));
            $("#pyaterochka h2").shouldHave(text("Пятёрочка"));
            $("#perekrestok h2").shouldHave(text("Перекрёсток"));
        });
    }

    @AllureId("2320")
    @Test
    @Feature("Карточка дебетовой карты Альфа-Карта")
    @Story("Открыть форму заказа Альфа-карты")
    @DisplayName("Order form should be loaded\n")
    void orderFormTest() {
        step("Открыть страницу дебетовых карт", () -> {
            open("everyday/debit-cards/");
        });
        step("Кликнуть на кнопку \"Заказать карту\"", () -> {
            $("#alfacard-benefit").$(byText("Заказать карту")).click();
        });
        step("Проверить, что открылась форма заказа", () -> {
            $("h1").shouldHave(text("Заявка на дебетовую Альфа-Карту"));
            $("#ApplyCardForm").shouldBe(visible);
        });
    }
}
