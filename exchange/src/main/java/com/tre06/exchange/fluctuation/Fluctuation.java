package com.tre06.exchange.fluctuation;

import com.tre06.exchange.Authentication;
import com.tre06.exchange.OnPageCompleteListener;
import com.tre06.exchange.PageCompleter;
import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.ResourceBundle;

public class Fluctuation {


    private List<String> date;
    private List<Double> buyrate;
    private List<Double> sellrate;
    private String time = "Weekly";
    @FXML
    private DatePicker startdate;
    @FXML
    private DatePicker enddate;
    @FXML
    private TextField starthour;
    @FXML
    private TextField endhour;
    @FXML
    public LineChart lineChart;
    @FXML
    ChoiceBox timeFrame ;


    private long starttimestamp = 1683537657;
    private long endtimestamp=1672531200;


   @FXML

   private void GetFluctuations() {
       time=timeFrame.getValue().toString();
       starttimestamp= conversion(startdate,starthour);
       endtimestamp=conversion(enddate,endhour);
       System.out.println(time);
       System.out.println(starttimestamp);
       System.out.println(endtimestamp);
       ExchangeService.exchangeApi().getGraph(new GraphQuery(time,starttimestamp,endtimestamp) ).enqueue(new Callback<Graph>() {
            @Override
            public void onResponse(Call<Graph> call, Response<Graph> response) {

            Graph fluctuation = response.body();
            Platform.runLater(() -> {
                date=fluctuation.Date;
                buyrate=fluctuation.buy;
                sellrate=fluctuation.sell;
                System.out.println(date.toString());

            });
            }
            @Override
            public void onFailure(Call<Graph> call, Throwable
            throwable) {
            }
            });
   }
        private void ShowChart(){
        XYChart.Series buy = new XYChart.Series();
        buy.setName("BuyRate"); //setting series name (appear as legends)
            System.out.println(date.toString());
            for (int i = 0; i < date.size(); i++) {

                buy.getData().add(new XYChart.Data(i,buyrate.get(i) ));
            }


        lineChart.getData().add(buy);
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
    private void timing(){
        timeFrame.getItems().addAll("Daily", "Weekly", "Hourly");
        // Set the default selection
        timeFrame.setValue("Weekly");
        // Add a listener to the choice box to handle changes in selection
        timeFrame.getSelectionModel().selectedIndexProperty().addListener(
                (observable, oldValue, newValue) -> {
                    switch (newValue.intValue()) {
                        case 0:

                            System.out.println(time);
                            // User selected "Days"
                            ShowChart();
                            break;
                        case 1:
                            // User selected "Weeks"
                            // TODO: update the chart with data for the selected timeframe
                            ShowChart();
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

        timing();
        // Add options to the timeframe choice box
//



    }

    }

