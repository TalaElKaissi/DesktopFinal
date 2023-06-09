package com.tre06.exchange.rates;

import com.tre06.exchange.Authentication;
import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.ExchangeRates;
import com.tre06.exchange.api.model.Transaction;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Rates {
    @FXML
    private ToggleGroup calculationType;

    @FXML
    private RadioButton lbpToUsdButton;
    public TextField resultTextField; // added field

    public TextField amountTextField; // added field

    public Label buyUsdRateLabel;
    public Label sellUsdRateLabel;
    public TextField lbpTextField;
    public TextField usdTextField;
    public ToggleGroup transactionType;
    public void initialize() {
        fetchRates();
    }
    private void fetchRates() {
        ExchangeService.exchangeApi().getExchangeRates().enqueue(new
         Callback<ExchangeRates>() {
             @Override
             public void onResponse(Call<ExchangeRates> call,
                                    Response<ExchangeRates> response) {
                 ExchangeRates exchangeRates = response.body();
                 Platform.runLater(() -> {

                     buyUsdRateLabel.setText(exchangeRates.lbpToUsd.toString());

                     sellUsdRateLabel.setText(exchangeRates.usdToLbp.toString());
                 });
             }
             @Override
             public void onFailure(Call<ExchangeRates> call, Throwable
                     throwable) {
             }
         });
    }
    @FXML // added method
    private void calculate() {
        double amount = Double.parseDouble(amountTextField.getText());
        double rate;
        double result;
        if (calculationType.getSelectedToggle() == lbpToUsdButton) {
            rate = Double.parseDouble(buyUsdRateLabel.getText());
            result=amount*(1/rate);
        } else {
            rate = Double.parseDouble(sellUsdRateLabel.getText());
            result=amount*rate;
        }

        resultTextField.setText(String.format("%.2f", result));
    }

    public void addTransaction(ActionEvent actionEvent) {
        Transaction transaction = new Transaction(
                Float.parseFloat(lbpTextField.getText()),
                Float.parseFloat(usdTextField.getText()),
                ((RadioButton)
                        transactionType.getSelectedToggle()).getText().equals("Sell USD")
        );
        String userToken = Authentication.getInstance().getToken();
        String authHeader = userToken != null ? "Bearer " + userToken : null;
        ExchangeService.exchangeApi().addTransaction(transaction, authHeader).enqueue(new Callback<Object>() {
            @Override
              public void onResponse(Call<Object> call, Response<Object>
                      response) {
                  fetchRates();
                  Platform.runLater(() -> {
                      usdTextField.setText("");
                      lbpTextField.setText("");
                  });
              }
              @Override
              public void onFailure(Call<Object> call, Throwable throwable)
              {
              }
          });
    }

}
