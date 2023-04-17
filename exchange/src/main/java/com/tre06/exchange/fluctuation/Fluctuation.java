package com.tre06.exchange.fluctuation;

import com.tre06.exchange.Authentication;
import com.tre06.exchange.OnPageCompleteListener;
import com.tre06.exchange.PageCompleter;
import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.Token;
import com.tre06.exchange.api.model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fluctuation implements PageCompleter {
    private OnPageCompleteListener
            onPageCompleteListener;




    @Override
    public void setOnPageCompleteListener(OnPageCompleteListener onPageCompleteListener) {
        this.onPageCompleteListener = onPageCompleteListener;
    }
}
