package controller;

import Services.PermissionHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import sun.jvm.hotspot.utilities.Observable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class MainWindowController {

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    public Button lblBtn = new Button();
    public static SimpleStringProperty Btn = new SimpleStringProperty("Anmelden");
    private ObservableStringValue txt = Btn;

    @FXML
    private void initialize() throws IOException {
        txt.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                lblBtn.setText(newValue);
            }
        });
    }


    @FXML
    private void handleShowAllPatient(ActionEvent e) throws SQLException, IOException {
        PermissionHelper perm = new PermissionHelper();
        String userrole = LoginController.getUserrole() == null ? "GUEST" : LoginController.getUserrole();
        int a = perm.checkAccessLevel(userrole, "PATIENTEN", "edit");

        if(a == 1) {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/AllPatientView.fxml"));
            try {
                mainBorderPane.setCenter(loader.load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            AllPatientController controller = loader.getController();
        }
        else {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/NoAccessView.fxml"));
            try {
                mainBorderPane.setCenter(loader.load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            NoAccessController controller = loader.getController();
        }
    }

    @FXML
    private void handleShowAllTreatments(ActionEvent e) throws SQLException, IOException {
        PermissionHelper perm = new PermissionHelper();
        String userrole = LoginController.getUserrole() == null ? "GUEST" : LoginController.getUserrole();
        int a = perm.checkAccessLevel(userrole, "BEHANDLUNGEN", "edit");

        if(a == 1) {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/AllTreatmentView.fxml"));
            try {
                mainBorderPane.setCenter(loader.load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            AllTreatmentController controller = loader.getController();
        }
        else {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/NoAccessView.fxml"));
            try {
                mainBorderPane.setCenter(loader.load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            NoAccessController controller = loader.getController();
        }
    }

    @FXML
    private void handleShowAllUsers(ActionEvent e) throws SQLException, IOException {
        PermissionHelper perm = new PermissionHelper();
        String userrole = LoginController.getUserrole() == null ? "GUEST" : LoginController.getUserrole();
        int a = perm.checkAccessLevel(userrole, "BENUTZER", "edit");

        if(a == 1) {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/AllUserView.fxml"));
            try {
                mainBorderPane.setCenter(loader.load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            AllUserController controller = loader.getController();
        }
        else {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/NoAccessView.fxml"));
            try {
                mainBorderPane.setCenter(loader.load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            NoAccessController controller = loader.getController();
        }
    }

    @FXML
    private void handleShowLogin(ActionEvent e) throws IOException {
        LoginController lc = new LoginController();
        // check what button label is set
        if(this.lblBtn.getText().equals("Abmelden")){
            lc.handleLogout();
            // redirect to no access View
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/NoAccessView.fxml"));
            try {
                mainBorderPane.setCenter(loader.load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            NoAccessController controller = loader.getController();

            // reset button label
            Btn.setValue("Anmelden");
        }
        else {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/LoginView.fxml"));
            try {
                mainBorderPane.setCenter(loader.load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            LoginController controller = loader.getController();
        }
    }
}
