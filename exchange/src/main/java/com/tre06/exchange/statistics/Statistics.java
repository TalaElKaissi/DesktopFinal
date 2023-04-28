package com.tre06.exchange.statistics;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;
public class Statistics implements Initializable{
    @FXML
    private ChoiceBox<Stats> statisticsChoiceBox;

    @FXML
    private VBox statisticsViewPane;

    @FXML
    private Label meanLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statisticsChoiceBox.getItems().addAll(new Mean(), new Nusers());
        statisticsChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue instanceof Mean) {
                double meanValue = ((Mean) newValue).ReturnMean();
                meanLabel.setText("Mean value: " + meanValue);
                statisticsViewPane.getChildren().clear();
            } else if (newValue instanceof Nusers) {
                PieChart chart = ((Nusers) newValue).CreateView();
                statisticsViewPane.getChildren().clear();
                statisticsViewPane.getChildren().add(chart);
            }
        });
        statisticsChoiceBox.getSelectionModel().selectFirst();
    }

}
