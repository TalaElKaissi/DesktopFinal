package com.tre06.exchange.statistics;

import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Volume implements Stats{
    private BarChart<String,Float> bar;

    public Volume() {
        String Euro = "Euro";
        String Pound = "British Pound";
        String A_Dollar = "Austrelian Dollar";
        String frenc= "Swis Franc";

        //Configuring category and NumberAxis
        CategoryAxis xaxis= new CategoryAxis();
        NumberAxis yaxis = new NumberAxis(0.1,2,0.1);
        xaxis.setLabel("Currency");
        yaxis.setLabel("Dollar price");

        //Configuring BarChart
        bar = new BarChart(xaxis,yaxis);
        bar.setTitle("Dollar Conversion chart");

        //Configuring Series for XY chart
        XYChart.Series<String,Float> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data(Euro,0.83));
        series.getData().add(new XYChart.Data(Pound,0.73));
        series.getData().add(new XYChart.Data(frenc,1.00));
        series.getData().add(new XYChart.Data(A_Dollar,1.32));

        //Adding series to the barchart
        bar.getData().add(series);
    }

    @Override
    public BarChart<String, Float> CreateView() {
        return bar;
    }
}
