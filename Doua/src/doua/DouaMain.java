/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doua;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author yassin
 */
public class DouaMain extends Application {

    double xOffset, yOffset;
    public static Stage stage = null;

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Doua.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        this.stage = primaryStage;

        primaryStage.getIcons().add(new Image("img/muslim.png"));

        primaryStage.show();

        //set Stage boundaries to the lower right corner of the visible bounds of the main screen
        //       Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//        stage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 450);
//        stage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 285);
//        double countx, county;
//        countx = primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 450;
//        county = primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 285;
//        System.out.println("countx " + countx);
//        System.out.println("county " + county);
//        stage.show();
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
