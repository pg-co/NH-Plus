package controller;

import datastorage.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    Button btnLogin;
    @FXML
    TextField txtUsername;
    @FXML
    PasswordField txtPassword;
    @FXML
    Label lblAccess;

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

        // check if input fields are filled
        if(!username.equals("") && !password.equals("")) {
            // check if inputs equal with test user data
            if(username.equals("Testuser") && password.equals("test")) {
                handleLogin();
            }
            // print text message if wrong input data
            else {
                this.lblAccess.setText("Anmeldung fehlgeschlagen! Versuchen Sie es erneut.");
            }
        }
        else {
            // print text message if empty input fields
            this.lblAccess.setText("Alle Felder müssen ausgefüllt sein!");
        }
    }

    private void handleLogin() {
        // print text message if login success
        this.lblAccess.setText("Erfolgreich angemeldet!");
    }
}
