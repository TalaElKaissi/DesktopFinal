package com.tre06.exchange.api;

import com.tre06.exchange.api.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface Exchange {
    @POST("/user")
    Call<User> addUser(@Body User user);
    @POST("/authentication")
    Call<Token> authenticate(@Body User user);
    @GET("/exchangeRate")
    Call<ExchangeRates> getExchangeRates();
    @POST("/transaction")
    Call<Object> addTransaction(@Body Transaction transaction,
            @Header("Authorization") String authorization);
    @GET("/transaction")
    Call<List<Transaction>> getTransactions(
            @Header("Authorization") String authorization);
    @GET("/usertransaction/list/offers")
    Call<List<Markets>> getMarket();
    @POST("/transaction/datapoints")
    Call<Graph> getGraph(@Body GraphQuery graphQuery);
    @GET("/news")
    Call<List<New>> getNew();
    @POST("/statistics")
    Call<Stat> getStat(@Body GraphQuery graphQuery);
    @POST("/news/post")
    Call<New> addNews(@Body New news, @Header("Authorization") String authorization);
    @POST("/predict")
    Call<Frate> getFrate(@Body Date date);
}