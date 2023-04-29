package com.tre06.exchange.statistics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Statistics {
    @FXML
    public PieChart PieChart;
    @FXML
    public PieChart BarChart;
    @FXML
    public Label Mean;
    @FXML
    public Label Standard;
    @FXML
    public Label Number;
    @FXML
    public Label Q1;
    @FXML
    public Label Q3;
    @FXML
    public Label Median;


    Nusers nUsers = new Nusers();
    PieChart pieChart = nUsers.CreateView();

    PieChart.setData(pieChart.getData());



}
