package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.*;

public class LoginController {
    @FXML
    Button btnLogin;
    @FXML
    TextField txtUsername;
    @FXML
    PasswordField txtPassword;
    @FXML
    Label lblAccess;

    public void initialize() throws IOException {
        handleShowLogin();
    }

    public void handleShowLogin() throws IOException {
        // check if usersession file is empty
        BufferedReader br = new BufferedReader(new FileReader("src/main/usersession.txt"));
        if(br.readLine() != null) {
            handleLogout();
        }
        else {
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
    }

    private void handleLogin() throws IOException {
        // print text message if login success
        this.lblAccess.setText("Erfolgreich angemeldet!");
        // write user session data to file
        FileWriter usersession = new FileWriter("src/main/usersession.txt");
        usersession.write("usersession1");
        usersession.close();
    }

    private void handleLogout() throws IOException {
        // delete user session data from file
        FileWriter usersession = new FileWriter("src/main/usersession.txt");
        usersession.write("");
        usersession.close();
    }
}
