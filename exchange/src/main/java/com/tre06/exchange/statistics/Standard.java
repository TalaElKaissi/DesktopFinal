package com.tre06.exchange.statistics;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class Standard implements Stats {
    private final Label StandardLabel;
    public Standard() {
        // Calculate mean value
        double Standard= ReturnStandard();

        // Create label to display mean value
        StandardLabel = new Label("Mean Value: " + Standard);
    }

    public double ReturnStandard() {
        // Replace this with your actual calculation logic
        return 42.0;
    }

    @Override
    public Node CreateView() {
        return StandardLabel;
    }
}
