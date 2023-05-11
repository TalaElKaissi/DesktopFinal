package com.tre06.exchange.predict;

import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.Date;
import com.tre06.exchange.api.model.Frate;
import com.tre06.exchange.api.model.GraphQuery;
import com.tre06.exchange.api.model.Stat;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Predict {
    @FXML
    private Label futurebuy;
    @FXML
    private Label futuresell;
    @FXML
    private DatePicker timing;
    private long timestamp = 1683537657;

    @FXML
    private void fetchPredictions(ActionEvent actionEvent){

        timestamp= convert(timing);


        System.out.println(timestamp);

        ExchangeService.exchangeApi().getFrate(new Date(1683537657L)).enqueue(new Callback<Frate>() {
            @Override
            public void onResponse(Call<Frate> call,
                                   Response<Frate> response) {
                Frate frate = response.body();
                System.out.println(timestamp);
                Platform.runLater(() -> {

                    futurebuy.setText(frate.fbuy.toString());
                    futuresell.setText(frate.fsell.toString());


                    ;
                });
            }

            @Override
            public void onFailure(Call<Frate> call, Throwable
                    throwable) {
            }
        });
    }
    public static long convert(DatePicker datePicker) {
        LocalDate selectedDate = datePicker.getValue();

        if (selectedDate != null) {
            LocalDateTime dateTime = selectedDate.atStartOfDay();
            return dateTime.toEpochSecond(ZoneOffset.UTC);
        } else {
            return 0;
        }
    }
}
