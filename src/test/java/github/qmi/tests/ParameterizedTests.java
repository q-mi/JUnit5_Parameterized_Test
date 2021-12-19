package github.qmi.tests;

import github.qmi.pages.LeonardoPage;
import github.qmi.pages.MyBookPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

public class ParameterizedTests extends TestBase {

    LeonardoPage leonardoPage = new LeonardoPage();
    MyBookPage MyBookPage = new MyBookPage();

    @ValueSource(strings = {"Карандаш", "Маркер", "Краска"})
    @DisplayName("Поиск товаров на сайте 'Leonardo'")
    @Tag("NORMAL")
    @ParameterizedTest(name = "Поиск товара {0} на сайте Leonardo и проверка отображения текста \"{0}\" в карточке товара")
    void valueSourceSearchProductLeonardo(String searchProduct) {
        leonardoPage.
                openPage().
                inputSearchQuery(searchProduct).
                checkNameProduct(searchProduct);
    }

    @EnumSource(ProductName.class)
    @DisplayName("Поиск товаров на сайте 'Leonardo'")
    @Tag("NORMAL")
    @ParameterizedTest(name = "Поиск товара {0} на сайте Leonardo и проверка отображения текста \"{0}\" в карточке товара")
    void enumSearchProductLeonardo(ProductName productName) {
        leonardoPage.
                openPage().
                inputSearchQuery(productName.getProductName()).
                checkNameProduct(productName.getProductName());
    }

    @EnumSource(BookName.class)
    @DisplayName("Поиск книг на сайте 'MyBook'")
    @Tag("NORMAL")
    @ParameterizedTest(name = "Поиск книги {0} и проверка её автора")
    void enumSearchProductMyBook(BookName bookName) {
        MyBookPage.
                openPage().
                setValueAndSearchQuery(bookName.getNameBook()).
                checkExpectedResultAuthor(bookName.getNameAutor());
    }


    @MethodSource
    @DisplayName("Поиск книг на сайте 'MyBook'")
    @Tag("NORMAL")
    @ParameterizedTest(name = "Поиск книги {0} и проверка, что её автор \"{1}\"")
    void methodSourceSearchProductMyBook(String booksNames, List<String> toolBooksNames) {
        MyBookPage.
                openPage().
                setValueAndSearchQuery(booksNames).
                checkExpectedResultAuthor(toolBooksNames.get(0));
    }

    static Stream<Arguments> methodSourceSearchProductMyBook() {
        return Stream.of(
                Arguments.of("Американские боги", List.of("Нил Гейман")),
                Arguments.of("Над кукушкиным гнездом", List.of("Кен Кизи")),
                Arguments.of("Чемодан", List.of("Сергей Довлатов")));
    }


    @CsvSource(value = {
            "Американские боги|Нил Гейман",
            "Над кукушкиным гнездом|Кен Кизи",
            "Чемодан|Сергей Довлатов"
    },
            delimiter = '|')
    @DisplayName("Поиск книг на сайте 'MyBook'")
    @Tag("NORMAL")
    @ParameterizedTest(name = "Поиск книги \"{0}\" и проверка, что её автор \"{1}\"")
    void csvSearchBookAndCheckAuthor(String nameBook, String author) {
        MyBookPage.
                openPage().
                setValueAndSearchQuery(nameBook).
                checkExpectedResultAuthor(author);
    }

    @CsvFileSource(resources = "/csvData.csv")
    @DisplayName("Поиск книг на сайте 'MyBook'")
    @Tag("NORMAL")
    @ParameterizedTest(name = "Поиск книги \"{0}\" и проверка, что её автор \"{1}\"")
    void csvFileSearchBookAndCheckAuthor(String nameBook, String author) {
        MyBookPage.
                openPage().
                setValueAndSearchQuery(nameBook).
                checkExpectedResultAuthor(author);
    }
}
