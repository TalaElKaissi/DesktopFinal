package com.tre06.exchange.statistics;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class Qone implements Stats{
    private final Label QoneLabel;
    public Qone() {
        // Calculate mean value
        double Qone= ReturnQone();

        // Create label to display mean value
        QoneLabel = new Label("Mean Value: " + Qone);
    }

    public double ReturnQone() {
        // Replace this with your actual calculation logic
        return 42.0;
    }

    @Override
    public Node CreateView() {
        return QoneLabel;
    }
}
