package com.tre06.exchange.statistics;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class Median implements Stats{
    private final Label medianLabel;
    public Median() {
        // Calculate mean value
        double median = ReturnMedian();

        // Create label to display mean value
        medianLabel = new Label("Mean Value: " + median);
    }

    public double ReturnMedian() {
        // Replace this with your actual calculation logic
        return 42.0;
    }

    @Override
    public Node CreateView() {
        return medianLabel;
    }
}
