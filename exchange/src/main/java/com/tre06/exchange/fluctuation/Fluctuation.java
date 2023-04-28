package com.tre06.exchange.fluctuation;

import com.tre06.exchange.Authentication;
import com.tre06.exchange.OnPageCompleteListener;
import com.tre06.exchange.PageCompleter;
import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.Token;
import com.tre06.exchange.api.model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.ResourceBundle;

public class Fluctuation {
//    private OnPageCompleteListener
//            onPageCompleteListener;
    @FXML
    public LineChart lineChart;
    @FXML
    ChoiceBox timeFrame ;
/*    @FXML
    public void Select(ActionEvent actionEvent) {


            }*/



//    @Override
//    public void setOnPageCompleteListener(OnPageCompleteListener onPageCompleteListener) {
//        this.onPageCompleteListener = onPageCompleteListener;
//    }

    private void ShowChart(){
        XYChart.Series Buy = new XYChart.Series();
        Buy.setName("BuyRate"); //setting series name (appear as legends)
        Buy.getData().add(new XYChart.Data(1, 23));
        Buy.getData().add(new XYChart.Data(2, 28));
        lineChart.getData().add(Buy);
    }
    private void Timing(){
        timeFrame.getItems().addAll("Days", "Weeks", "Hours");
        // Set the default selection
        timeFrame.setValue("Days");
        // Add a listener to the choice box to handle changes in selection
        timeFrame.getSelectionModel().selectedIndexProperty().addListener(
                (observable, oldValue, newValue) -> {
                    switch (newValue.intValue()) {
                        case 0:
                            // User selected "Days"
                            ShowChart();
                            break;
                        case 1:
                            // User selected "Weeks"
                            // TODO: update the chart with data for the selected timeframe
                            break;
                        case 2:
                            // User selected "Hours"
                            // TODO: update the chart with data for the selected timeframe
                            break;
                    }
                }
        );

    }
    public void initialize() {

        Timing();
        // Add options to the timeframe choice box
//



    }

    }

