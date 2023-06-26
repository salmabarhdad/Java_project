module com.example.projet_chatapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projet_chatapp to javafx.fxml;
    exports com.example.projet_chatapp;
}