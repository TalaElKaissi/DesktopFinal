package com.tre06.exchange.api.model;

import com.google.gson.annotations.SerializedName;

public class Stat{
    @SerializedName("lbpRateChangeBasedOnTimeFormatBetweenDates")
    public Double taglbpRateChange;
    @SerializedName("numberOfLbpTransactionsBetweenDates")
    public Double tagnumLbpTransactions;
    @SerializedName("numberOfTransactionsBetweenDates")
    public Double  tagnumTransactions;
    @SerializedName("numberOfUsdTransactionsBetweenDates")
    public Double tagnumUsdTransactions;
    @SerializedName("totalTransactionsToday")
    public Double tagtotalTransactions;
    @SerializedName("usdRateChangeBasedOnTimeFormatBetweenDates")
    public Double tagusdRateChange;

}
