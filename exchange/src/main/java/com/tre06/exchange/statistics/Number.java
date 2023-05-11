package com.tre06.exchange.statistics;

import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Number implements Stats {
    private final Label NumberLabel;
    public Number() {
        // Calculate mean value
        double median = ReturnNumber();

        // Create label to display mean value
        NumberLabel = new Label("Mean Value: " + median);
    }

    public double ReturnNumber() {
        // Replace this with your actual calculation logic
        return 42.0;
    }

    @Override
    public Node CreateView() {
        return NumberLabel;
    }
}


