package github.qmi.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MyBookPage {

    private SelenideElement
            searchField = $(".ant-input");

    private ElementsCollection
            listAuthor = $$("div.dey4wx-1.jVKkXg");

    public MyBookPage openPage() {
        open("https://mybook.ru/");

        return this;
    }

    public MyBookPage setValueAndSearchQuery(String searchQuery) {
        searchField.setValue(searchQuery).pressEnter();

        return this;
    }

    public MyBookPage checkExpectedResultAuthor(String expectedResultAuthor) {
        listAuthor.findBy(text(expectedResultAuthor)).click();

        return this;
    }
}
