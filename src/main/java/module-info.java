module com.example.javamiage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javamiage to javafx.fxml;
    exports com.example.javamiage;
}