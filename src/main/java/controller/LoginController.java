package controller;

import datastorage.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Patient;
import utils.DateConverter;

import java.sql.SQLException;
import java.time.LocalDate;

public class LoginController {
    @FXML
    Button btnLogin;
    @FXML
    TextField txtUsername;
    @FXML
    TextField txtPassword;

    private LoginController controller;
    private Stage stage;

    public void initialize(LoginController controller, Stage stage) {
        this.controller= controller;
        this.stage = stage;
        handleShowLogin();
    }

    public void handleShowLogin(){
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();
    }
}
