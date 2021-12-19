package github.qmi.tests;

public enum BookName {
    AMERICAN_GODS("Американские боги", "Нил Гейман"),
    ONE_FLEW_OVER_THE_CUCKOOS_NEST("Над кукушкиным гнездом", "Кен Кизи"),
    THE_SUITCASE("Чемодан", "Сергей Довлатов");

    private final String name_book;
    private final String name_autor;

    BookName(String name_book, String name_autor) {
        this.name_book = name_book;
        this.name_autor = name_autor;
    }

    public String getNameBook() {
        return name_book;
    }

    public String getNameAutor() {
        return name_autor;
    }
}
