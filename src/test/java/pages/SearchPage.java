package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    public SearchPage open() {
        Selenide.open("/busca");
        return this;
    }

    public SearchPage filterDate() {
        $(".filters__advanced-date-filter").click();
        $(".filters__dropdown__list__range-date").click();
        $(By.cssSelector("div.DayPicker_transitionContainer.DayPicker_transitionContainer_1.DayPicker_transitionContainer__horizontal.DayPicker_transitionContainer__horizontal_2 > div > div:nth-child(2) > div > table > tbody > tr:nth-child(1) > td.CalendarDay.CalendarDay_1.CalendarDay__default.CalendarDay__default_2.CalendarDay__lastDayOfWeek.CalendarDay__lastDayOfWeek_3")).click();
        $(By.cssSelector(".range-date-filter-modal__btn-section > button")).click();
        return this;
    }

    public SearchPage paginacao() {
        $(".pagination > a").waitUntil(Condition.visible, 10000).click();
        return this;
    }

    public ElementsCollection itens() {
        return $$(".results__list > li > .widget--info__text-container > a > .widget--info__title");
    }
}
