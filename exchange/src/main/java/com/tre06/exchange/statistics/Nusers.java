package com.tre06.exchange.statistics;

import javafx.scene.chart.PieChart;

import java.util.Arrays;
import java.util.List;

public class Nusers implements Stats{
    private final List<PieChart.Data> data = Arrays.asList(
        new PieChart.Data("User A", 10),
        new PieChart.Data("User B", 20),
        new PieChart.Data("User C", 30),
        new PieChart.Data("User D", 40),
        new PieChart.Data("User E", 50)
);

    @Override
    public PieChart CreateView() {
        PieChart chart = new PieChart();
        chart.setTitle("Number of Users");
        chart.getData().addAll(data);
        return chart;

    }


}
