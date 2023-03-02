module com.tre06.exchange {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tre06.exchange to javafx.fxml;
    exports com.tre06.exchange;
}