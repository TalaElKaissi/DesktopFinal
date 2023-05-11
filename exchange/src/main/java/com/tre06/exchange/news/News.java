package com.tre06.exchange.news;

import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.New;
import javafx.application.Platform;
import javafx.scene.control.Label;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;


public class News {
    public Label New1;
    public Label New2;
    public Label New3;
    public void initialize() {
        fetchNews();
    }
    private void fetchNews(){
        ExchangeService.exchangeApi().getNew().enqueue(new Callback <List<New>>() {
            @Override
            public void onResponse(Call<List<New>> call,
                                   Response<List<New>> response) {
                List<New> news = response.body();
                Platform.runLater(() -> {

                    New1.setText(news.get(0).news+"\n"+news.get(0).newsName+"\n"+news.get(0).addedDate);
                    New2.setText(news.get(1).news+"\n"+news.get(1).newsName+"\n"+news.get(1).addedDate);
                    New3.setText(news.get(2).news+"\n"+news.get(2).newsName+"\n"+news.get(2).addedDate);
                });
            }

            @Override
            public void onFailure(Call<List<New>> call, Throwable
                    throwable) {
            }
        });
    }
}
