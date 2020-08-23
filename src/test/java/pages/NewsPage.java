package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class NewsPage {
    public SelenideElement tituloNoticia() {
        return $("h1.content-head__title");
    }
}
