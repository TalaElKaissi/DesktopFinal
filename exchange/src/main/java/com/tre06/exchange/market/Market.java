package com.tre06.exchange.market;

import com.tre06.exchange.Authentication;
import com.tre06.exchange.api.ExchangeService;
import com.tre06.exchange.api.model.Markets;
import com.tre06.exchange.api.model.Transaction;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Market implements Initializable {
    public TableColumn Trader;
    public TableColumn Status;
    public TableColumn Price;
    public TableColumn Amount;
    public TableView tableView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Trader.setCellValueFactory(new PropertyValueFactory<Markets, String>("trader"));
        Status.setCellValueFactory(new PropertyValueFactory<Markets, Long>("status"));
        Price.setCellValueFactory(new PropertyValueFactory<Markets, String>("price"));
        Amount.setCellValueFactory(new PropertyValueFactory<Markets, String>("amount"));
        ExchangeService.exchangeApi().getMarket().enqueue(new Callback<List<Markets>>() {
                    @Override
                    public void onResponse(Call<List<Markets>> call,
                                           Response<List<Markets>> response) {
                        tableView.getItems().setAll(response.body());                     }
                    @Override
                    public void onFailure(Call<List<Markets>> call, Throwable throwable) {

                    }
                });
    }
}
