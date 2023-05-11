package com.tre06.exchange.api.model;

import com.google.gson.annotations.SerializedName;

public class Frate {
    @SerializedName("usd_to_lbp")
    public Double fbuy;
    @SerializedName("lbp_to_usd")
    public Double fsell;
}
