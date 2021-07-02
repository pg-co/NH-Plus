package controller;

import datastorage.DAOFactory;
import datastorage.PatientDAO;
import datastorage.TreatmentDAO;
import datastorage.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Patient;
import model.User;
import utils.DateConverter;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AllUserController {
    @FXML
    private TableColumn<User,Integer> colID;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> colFirstName;
    @FXML
    private TableColumn<User, String> colSurname;
    @FXML
    private TableColumn<User, String> colUsername;
    @FXML
    private TableColumn<User, String> colRole;
    @FXML
    Button btnDelete;
    @FXML
    Button btnAdd;
    @FXML
    Button btnback;
    @FXML
    TextField txtSurname;
    @FXML
    TextField txtFirstname;
    @FXML
    TextField txtUsername;
    @FXML
    TextField txtPassword;
    @FXML
    TextField txtRole;
    @FXML
    TextField txtID;


    private ObservableList<User> tableviewContent = FXCollections.observableArrayList();
    private UserDAO dao;

    public void initialize() {
        readAllAndShowInTableView();
    // TESTING NEW GIT CONFIG
        this.colID.setCellValueFactory(new PropertyValueFactory<User, Integer>("ID"));

        //CellValuefactory zum Anzeigen der Daten in der TableView
        this.colFirstName.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
        this.colFirstName.setCellFactory(TextFieldTableCell.forTableColumn());

        this.colSurname.setCellValueFactory(new PropertyValueFactory<User, String>("surname"));
        this.colSurname.setCellFactory(TextFieldTableCell.forTableColumn());

        this.colUsername.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        this.colUsername.setCellFactory(TextFieldTableCell.forTableColumn());


        this.colRole.setCellValueFactory(new PropertyValueFactory<User, String>("rolename"));
        this.colRole.setCellFactory(TextFieldTableCell.forTableColumn());


        //Anzeigen der Daten
        this.tableView.setItems(this.tableviewContent);
    }
    @FXML
    public void handleOnEditFirstname(TableColumn.CellEditEvent<User, String> event){
        event.getRowValue().setFirstName(event.getNewValue());
        doUpdate(event);
    }

    /**
     * handles new surname value
     * @param event event including the value that a user entered into the cell
     */
    @FXML
    public void handleOnEditSurname(TableColumn.CellEditEvent<User, String> event){
        event.getRowValue().setSurname(event.getNewValue());
        doUpdate(event);
    }

    /**
     * handles new birthdate value
     * @param event event including the value that a user entered into the cell
     */

    @FXML
    public void handleOnUsername(TableColumn.CellEditEvent<User, String> event){
        event.getRowValue().SetUsername(event.getNewValue());
        doUpdate(event);
    }

    /**
     * handles new roomnumber value
     * @param event event including the value that a user entered into the cell
     */
    @FXML
    public void handleOnEditRole(TableColumn.CellEditEvent<User, String> event){
        event.getRowValue().SetRole(event.getNewValue());
        doUpdate(event);
    }
    public void handleDeleteRow() {
        UserDAO uDao = DAOFactory.getDAOFactory().createUserDAO();
        User selectedItem = this.tableView.getSelectionModel().getSelectedItem();
        try {
            dao.deleteById(selectedItem.getID());
            this.tableView.getItems().remove(selectedItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void doUpdate(TableColumn.CellEditEvent<User, String> t) {
        try {
            dao.update(t.getRowValue());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleAdd() {
        String surname = this.txtSurname.getText();
        String firstname = this.txtFirstname.getText();
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();
        String role= this.txtRole.getText();
        String id = this.txtID.getText();
        try {
            User u = new User( Integer.parseInt(id),firstname, surname, username, password, role);
            dao.create(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        readAllAndShowInTableView();
        clearTextfields();
    }
    private void readAllAndShowInTableView() {
        this.tableviewContent.clear();
        this.dao = DAOFactory.getDAOFactory().createUserDAO();
        List<User> allUsers;
        try {
            allUsers = dao.readAll();
            for (User u : allUsers) {
                this.tableviewContent.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void clearTextfields() {
        this.txtFirstname.clear();
        this.txtSurname.clear();
        this.txtRole.clear();
        this.txtID.clear();
        this.txtUsername.clear();
        this.txtPassword.clear();
    }
}
