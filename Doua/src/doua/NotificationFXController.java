/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doua;

import com.jfoenix.controls.JFXTextArea;
import static doua.DouaController.SwitchModeActuel;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.lang.Math;
import service.Notification;

/**
 * FXML Controller class
 *
 * @author yassin
 */
public class NotificationFXController implements Initializable {

    @FXML
    private HBox notificationBox;
    @FXML
    private Label textDoua;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String RandomGradient = Notification.RandomGradient();
        this.textDoua.setText("");
        if (SwitchModeActuel == "Night") {
            notificationBox.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;");
            //notificationVBox.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 60%);-fx-background-radius:  15px 15px 30px 30px;");
            this.textDoua.setTextFill(Color.WHITE);
        } else {
            notificationBox.setStyle(RandomGradient+"-fx-background-radius: 20px 20px 20px 20px;");
            // notificationVBox.setStyle("-fx-background-color:  White;-fx-background-radius:  15px 15px 30px 30px;");
            this.textDoua.setTextFill(Color.WHITE);
        }

    }

    public void setDoua(String msg) {
        this.textDoua.setText(msg);
        //   this.txtDoua.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        this.textDoua.setAlignment(Pos.CENTER); //center Text
    }


}
