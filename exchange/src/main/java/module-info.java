module com.tre06.exchange {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires java.sql;
    requires gson;
    requires java.prefs;
    requires retrofit2.converter.gson;
    opens com.tre06.exchange to javafx.fxml;
    opens com.tre06.exchange.api.model to javafx.base,gson;
    exports com.tre06.exchange;
    exports com.tre06.exchange.rates;
    exports com.tre06.exchange.statistics;
    opens com.tre06.exchange.statistics to javafx.fxml;
    opens com.tre06.exchange.rates to javafx.fxml;
    opens com.tre06.exchange.login to javafx.fxml;
    opens com.tre06.exchange.register to javafx.fxml;
    opens com.tre06.exchange.news to javafx.fxml;
    opens com.tre06.exchange.transactions to javafx.fxml;
    opens com.tre06.exchange.fluctuation to javafx.fxml;
    opens com.tre06.exchange.market to javafx.fxml;
    opens com.tre06.exchange.predict to javafx.fxml;
    opens com.tre06.exchange.announcement to javafx.fxml;


        }