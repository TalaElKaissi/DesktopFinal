package com.tre06.exchange.api.model;


import com.google.gson.annotations.SerializedName;

public class GraphQuery {
    @SerializedName("timeFormat")
    public String time;
    @SerializedName("startDate")
    public Long start;
    @SerializedName("endDate")
    public Long end;
    public GraphQuery(String time,Long start,Long end )
    {
        this.time = time;
        this.start=start;
        this.end=end;



    }

}
