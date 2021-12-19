package github.qmi.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LeonardoPage {
    private SelenideElement
            searchField = $("#collapseExample > div > input");

    private ElementsCollection
            titleProduct = $$("div.product-title a");

    public LeonardoPage openPage() {
        open("https://leonardo.ru/");

        return this;
    }

    public LeonardoPage inputSearchQuery(String searchProduct) {
        searchField.setValue(searchProduct).pressEnter();

        return this;
    }

    public LeonardoPage checkNameProduct(String searchProduct) {
        titleProduct.findBy(text(searchProduct)).scrollTo();

        return this;
    }

}



