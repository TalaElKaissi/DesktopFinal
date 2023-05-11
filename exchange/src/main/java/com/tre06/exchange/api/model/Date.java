package com.tre06.exchange.api.model;

import com.google.gson.annotations.SerializedName;

public class Date {
    @SerializedName("date")
    public Long date;
    public Date(Long date )
    {
        this.date=date;



    }
}
