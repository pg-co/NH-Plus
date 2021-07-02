package controller;

import datastorage.DAOFactory;
import datastorage.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class LoginController {
    @FXML
    Button btnLogin;
    @FXML
    TextField txtUsername;
    @FXML
    PasswordField txtPassword;
    @FXML
    Label lblAccess;
    String dbUsername, dbPassword, username, password, dbRolename;

    public void initialize() throws IOException {
        handleShowLogin();
    }

    public void handleShowLogin() throws IOException {
        username = this.txtUsername.getText();
        password = this.txtPassword.getText();

        // get user data from database
        UserDAO uDao = DAOFactory.getDAOFactory().createUserDAO();
        List<User> allUsers;

        // check if input fields are filled
        if(!username.equals("") && !password.equals("")) {
            // check if inputs equal database data
            try {
                allUsers = uDao.readAll();
                for (User u : allUsers) {
                    dbUsername = u.getUsername();
                    dbPassword = u.getPassword();
                    dbRolename = u.getRolename();

                    if(username.equals(dbUsername) && password.equals(dbPassword)) {
                        handleLogin(dbRolename);
                        break;
                    }
                    // print text message if wrong input data
                    else {
                        this.lblAccess.setText("Anmeldung fehlgeschlagen! Versuchen Sie es erneut.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleLogin(String rolename) throws IOException {
        // print text message if login success
        this.lblAccess.setText("Erfolgreich angemeldet!");
        // write user session data to file
        FileWriter usersession = new FileWriter("src/main/usersession.txt");
        usersession.write(rolename);
        usersession.close();
        // set button label
        MainWindowController.Btn.setValue("Abmelden");
    }

    protected void handleLogout() throws IOException {
        // delete user session data from file
        FileWriter usersession = new FileWriter("src/main/usersession.txt");
        usersession.write("");
        usersession.close();
    }

    public static String getUserrole() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/usersession.txt"));
        return br.readLine();
    }
}
