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

        this.textDoua.setText("");
        if (SwitchModeActuel == "Night") {
            notificationBox.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;");
            //notificationVBox.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 60%);-fx-background-radius:  15px 15px 30px 30px;");
            this.textDoua.setTextFill(Color.WHITE);
        } else {
            notificationBox.setStyle(RandomGradient());
            // notificationVBox.setStyle("-fx-background-color:  White;-fx-background-radius:  15px 15px 30px 30px;");
            this.textDoua.setTextFill(Color.WHITE);
        }

    }

    public void setDoua(String msg) {
        this.textDoua.setText(msg);
        //   this.txtDoua.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        this.textDoua.setAlignment(Pos.CENTER); //center Text
    }

    public String RandomGradient() {
        String GRADIENT = "";
        int random = (int) (Math.random() * (10 - 1 + 1) + 1);
        if (random == 1) {//Rose
            GRADIENT = "-fx-background-color:  linear-gradient(to right top, #f2709c , #ff9472);-fx-background-radius: 20px 20px 20px 20px;";
        }
        if (random == 2) {//azre9
            GRADIENT = "-fx-background-color:  linear-gradient(to right top, #56CCF2 , #2F80ED);-fx-background-radius: 20px 20px 20px 20px;";
        }
        if (random == 3) {//orangé
            GRADIENT = "-fx-background-color:  linear-gradient(to right top, #FDC830 , #F37335);-fx-background-radius: 20px 20px 20px 20px;";
        }
        if (random == 4) {//violet
            GRADIENT = "-fx-background-color:  linear-gradient(to right top, #DA4453 , #89216B);-fx-background-radius: 20px 20px 20px 20px;";
        }
        if (random == 5) {//Dark Green
            GRADIENT = "-fx-background-color:  linear-gradient(to right top, #136a8a , #267871);-fx-background-radius: 20px 20px 20px 20px;";
        }
        if (random == 6) {//Dark blue
            GRADIENT = "-fx-background-color: linear-gradient(to right, #1e3c72 0%, #2a5298  51%, #1e3c72  100%);-fx-background-radius: 20px 20px 20px 20px;";
        }
        if (random == 7) {//orangé foncé
            GRADIENT = "-fx-background-color:  linear-gradient(to right, #FFD3A5 10%, #FD6585 100%);-fx-background-radius: 20px 20px 20px 20px;";
        }
        if (random == 8) {//Black
            GRADIENT = "-fx-background-color: linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;";
        }
        if (random == 9) {//Yellow
            GRADIENT = "-fx-background-color: linear-gradient(to bottom, #4776E6 0%, #8E54E9 74%);-fx-background-radius: 20px 20px 20px 20px;";
        }
        if (random == 10) {//Green
            GRADIENT = "-fx-background-color: linear-gradient(to right top, #11998e 0%, #38ef7d 100%);-fx-background-radius: 20px 20px 20px 20px;";
        }

        return GRADIENT;
    }

}
