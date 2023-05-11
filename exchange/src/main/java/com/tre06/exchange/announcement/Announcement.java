package com.tre06.exchange.announcement;

import com.tre06.exchange.Authentication;
import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.New;
import com.tre06.exchange.api.model.Transaction;
import com.tre06.exchange.news.News;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Announcement {
    @FXML
    private TextArea Announce;
    private New news;
    public void addNews(ActionEvent actionEvent){
    news.news=Announce.getText();
        String userToken = Authentication.getInstance().getToken();
        String authHeader = userToken != null ? "Bearer " + userToken : null;
                ExchangeService.exchangeApi().addNews(news,authHeader)
                        .enqueue(new Callback<New>() {
                            @Override
                            public void onResponse(Call<New> call,
                                                   Response<New> response) {
                                Platform.runLater(() -> {
                                    Announce.setText("");

                                });

                            }
                            @Override
                            public void onFailure(Call<New> call, Throwable throwable) {

                            }
                        });



    }


}
