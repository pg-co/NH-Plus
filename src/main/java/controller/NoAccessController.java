package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NoAccessController {

    @FXML
    Label txtAccess;

    public void initialize() {
        accessMessage("Sie haben nicht die notwendigen Zugriffsrechte für diese Seite.");
    }

    public void accessMessage(String message) {
        txtAccess.setText(message);
    }
}
