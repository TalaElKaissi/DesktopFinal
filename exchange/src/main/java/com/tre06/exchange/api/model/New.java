package com.tre06.exchange.api.model;

import com.google.gson.annotations.SerializedName;

public class New {
    @SerializedName("added_date")
    public String addedDate;
    @SerializedName("news")
    public String news;
    @SerializedName("newscaster_username")
    public String newsName;
    public New ( String news){

        this.news=news;


    }

}
