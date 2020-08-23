package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public HomePage open() {
        Selenide.open("/");
        return this;
    }

    public HomePage search(String busca) {
        $("#home-search-field").setValue(busca);
        $(".home-header__search-button").click();
        return this;
    }
}
