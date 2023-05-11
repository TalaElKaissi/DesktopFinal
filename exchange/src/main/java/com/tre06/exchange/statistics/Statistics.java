package com.tre06.exchange.statistics;

import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.Graph;
import com.tre06.exchange.api.model.GraphQuery;
import com.tre06.exchange.api.model.New;
import com.tre06.exchange.api.model.Stat;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.ResourceBundle;

public class Statistics  {

    @FXML
    private Label lbpRateChange;
    @FXML
    private Label numLbpTransactions;
    @FXML
    private Label numTransactions;
    @FXML
    private Label numUsdTransactions;
    @FXML
    private Label totalTransactions;
    @FXML
    private Label usdRateChange;
    @FXML
    private DatePicker startdate;
    private String time = "Weekly";
    @FXML
    private DatePicker enddate;
    @FXML
    private TextField starthour;
    @FXML
    private TextField endhour;
    @FXML
    ChoiceBox timeFrame ;
    private long starttimestamp = 1683537657;
    private long endtimestamp=1672531200;

    private void fetchStatistics(){
        time=timeFrame.getValue().toString();
        starttimestamp= conversion(startdate,starthour);
        endtimestamp=conversion(enddate,endhour);
        System.out.println(time);
        System.out.println(starttimestamp);
        System.out.println(endtimestamp);
        ExchangeService.exchangeApi().getStat(new GraphQuery(time, starttimestamp, endtimestamp)).enqueue(new Callback <Stat>() {
            @Override
            public void onResponse(Call<Stat> call,
                                   Response<Stat> response) {
                Stat stat = response.body();
                Platform.runLater(() -> {
                    lbpRateChange.setText(stat.taglbpRateChange.toString());
                    numLbpTransactions.setText(stat.tagnumLbpTransactions.toString());
                    numTransactions.setText(stat.tagnumTransactions.toString());
                    numUsdTransactions.setText(stat.tagnumUsdTransactions.toString());
                    totalTransactions.setText(stat.tagtotalTransactions.toString());
                    usdRateChange.setText(stat.tagusdRateChange.toString());

                   ;
                });
            }

            @Override
            public void onFailure(Call<Stat> call, Throwable
                    throwable) {
            }
        });
    }
    private long conversion(DatePicker day, TextField hourinput) {
        LocalDate selectedDate = day.getValue();
        String hourText = hourinput.getText();
        long unixTimestamp=0;
        if (selectedDate != null && !hourText.isEmpty()) {
            int hour = Integer.parseInt(hourText);
            if (hour >= 0 && hour <= 23) {
                LocalDateTime dateTime = LocalDateTime.of(selectedDate.getYear(), selectedDate.getMonth(),
                        selectedDate.getDayOfMonth(), hour, 0, 0);
                unixTimestamp = dateTime.toEpochSecond(ZoneOffset.UTC);
                System.out.println("Unix timestamp: " + unixTimestamp);
            } else {
                System.out.println("Invalid hour value. Please enter an integer from 0 to 23.");
            }
        }
        return unixTimestamp;
    }
    public void initialize() {

        timing();
        // Add options to the timeframe choice box
//



    }
    private void timing() {
        timeFrame.getItems().addAll("Daily", "Weekly", "Hourly");
        // Set the default selection
        timeFrame.setValue("Weekly");
        time = timeFrame.toString();
        starttimestamp = conversion(startdate, starthour);
        endtimestamp = conversion(enddate, endhour);
        // Add a listener to the choice box to handle changes in selection
        timeFrame.getSelectionModel().selectedIndexProperty().addListener(
                (observable, oldValue, newValue) -> {
                    fetchStatistics();
                });
    }



}
