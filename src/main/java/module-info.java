module MyApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens com.example.demo to javafx.fxml;
    opens prod to javafx.fxml;

    exports com.example.demo;
    exports prod;
}
