package com.tre06.exchange.api.model;

import com.google.gson.annotations.SerializedName;

public class Markets {
    @SerializedName("seller_username")
    public String trader;
    @SerializedName("status")
    public String status;
    @SerializedName("usd_amount")
    public Integer price;
    @SerializedName("lbp_amount")
    public Integer amount;


    public String getTrader() {
        return trader;
    }

    public String getStatus() {
        return status;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }





}
