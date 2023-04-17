package com.tre06.exchange;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable; 
import javafx.scene.control.Button; 
import javafx.scene.layout.BorderPane;  
import java.io.IOException; 
import java.net.URL; 
import java.util.ResourceBundle;  
public class Parent implements Initializable, OnPageCompleteListener{
    public BorderPane borderPane;      
    public  Button transactionButton;
    public  Button loginButton;
    public  Button fluctuationButton;
    public  Button registerButton;
    public  Button logoutButton;
    @Override     
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateNavigation();
    }
    private void updateNavigation() {
        boolean authenticated = Authentication.getInstance().getToken() !=
                null;
        transactionButton.setManaged(authenticated);
        transactionButton.setVisible(authenticated);
        fluctuationButton.setManaged(true);
        fluctuationButton.setVisible(true);
        loginButton.setManaged(!authenticated);
        loginButton.setVisible(!authenticated);
        registerButton.setManaged(!authenticated);
        registerButton.setVisible(!authenticated);
        logoutButton.setManaged(authenticated);
        logoutButton.setVisible(authenticated);
    }
    public void ratesSelected() {swapContent(Section.RATES);}
    public void transactionsSelected() {swapContent(Section.TRANSACTIONS);}
    public void loginSelected() {
                swapContent(Section.LOGIN);     
                }
    public void fluctuationSelected(){swapContent(Section.FLUCTUATION);}
    public void registerSelected() {
                swapContent(Section.REGISTER);     
                }
    public void logoutSelected() {
                   Authentication.getInstance().deleteToken();
                   swapContent(Section.RATES);
           }
    private void swapContent(Section section) {
        try {
            URL url = getClass().getResource(section.getResource());
            FXMLLoader loader = new FXMLLoader(url);
            borderPane.setCenter(loader.load());
            if (section.doesComplete()) {
                ((PageCompleter)
                        loader.getController()).setOnPageCompleteListener(this);
            }
            updateNavigation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPageCompleted() {
        swapContent(Section.RATES);
    }

    private enum Section {

                    RATES,         
                    TRANSACTIONS,         
                    LOGIN,         
                    REGISTER,
                    FLUCTUATION;
        public boolean doesComplete() {
            return switch (this) {
                case LOGIN, REGISTER -> true;
                default -> false;
            };
        }



        public String getResource() {
                        return switch (this) {                 
                            case RATES -> "/com/tre06/exchange/rates/rates.fxml";
                            case TRANSACTIONS -> "/com/tre06/exchange/transactions/transactions.fxml";
                            case LOGIN -> "/com/tre06/exchange/login/login.fxml";
                            case REGISTER -> "/com/tre06/exchange/register/register.fxml";
                            case FLUCTUATION -> "/com/tre06/exchange/fluctuation/fluctuation.fxml";
                            default -> null;             
                        };         
                            
                        }          
                            
                    } }