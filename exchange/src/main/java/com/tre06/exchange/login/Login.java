package com.tre06.exchange.login;

import com.tre06.exchange.Authentication;
import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.Token;
import com.tre06.exchange.api.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login {
    public TextField usernameTextField;
    public TextField passwordTextField;
    public void login(ActionEvent actionEvent) {
        User user = new User(usernameTextField.getText(), passwordTextField.getText());
        ExchangeService.exchangeApi().authenticate(user).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Authentication.getInstance().saveToken(response.body().getToken());
            }
            @Override
            public void onFailure(Call<Token> call, Throwable throwable) {

            }
        });
    } }