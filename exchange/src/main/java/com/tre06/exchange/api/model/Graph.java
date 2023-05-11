package com.tre06.exchange.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Graph {

    @SerializedName("averagesUsdToLbp")
    public List<Double> buy;
    @SerializedName("averagesLbpToUsd")
    public List<Double> sell;
    @SerializedName("dates")
    public List<String> Date;

}
