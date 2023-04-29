package com.tre06.exchange.statistics;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class Qthree implements Stats{
    private final Label QthreeLabel;
    public Qthree() {
        // Calculate mean value
        double Qthree= ReturnQthree();

        // Create label to display mean value
        QthreeLabel = new Label("Mean Value: " + Qthree);
    }

    public double ReturnQthree() {
        // Replace this with your actual calculation logic
        return 42.0;
    }

    @Override
    public Node CreateView() {
        return QthreeLabel;
    }
}
