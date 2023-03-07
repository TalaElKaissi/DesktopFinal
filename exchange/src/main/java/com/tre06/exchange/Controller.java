package com.tre06.exchange;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller {
    public Label buyUsdRateLabel;
    public Label sellUsdRateLabel;
    public TextField lbpTextField;
    public TextField usdTextField;
    public ToggleGroup transactionType;
    public void initialize() {
        fetchRates();
    }
    private void fetchRates() {

    }
    public void addTransaction(ActionEvent actionEvent) {

    }
}
