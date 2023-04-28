package com.tre06.exchange.statistics;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class Mean implements Stats{

    private final Label meanLabel;

    public Mean() {
        // Calculate mean value
        double mean = ReturnMean();

        // Create label to display mean value
        meanLabel = new Label("Mean Value: " + mean);
    }

    public double ReturnMean() {
        // Replace this with your actual calculation logic
        return 42.0;
    }

    @Override
    public Node CreateView() {
        return meanLabel;
    }
}
