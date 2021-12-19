package github.qmi.tests;

public enum ProductName {
    PENCIL("Карандаш"),
    MARKER("Маркер"),
    PAINT("Краска");

    private final String productName;

    ProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}


