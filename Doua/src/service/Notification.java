package service;

import service.Notifications;
import static doua.DouaMain.stage;
import doua.NotificationFXController;
import doua.NotificationFXController;
import java.io.File;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Notification {

    private static MediaPlayer MEDIA_PLAYER;

    public static void CreateNotificationMinutes(String msg, double duration) {
        try {
            FXMLLoader loader = new FXMLLoader(Notification.class.getResource("/doua/NotificationsFX.fxml"));
            Parent notificationView = loader.load();
            ((NotificationFXController) loader.getController()).setDoua(msg);
            Platform.runLater(() -> Notifications.create()
                    .graphic(notificationView)
                    .hideCloseButton()
                    .hideAfter(Duration.minutes(duration))
                    .onAction(event -> {System.out.println("Notifcation is Closed !");})
                    .position(Pos.BOTTOM_RIGHT).show());
                    Playsound(); // Sound Notification
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void CreateNotificationSeconds(String msg, double duration) {
        try {
            FXMLLoader loader = new FXMLLoader(Notification.class.getResource("/doua/NotificationsFX.fxml"));
            Parent notificationView = loader.load();
            ((NotificationFXController) loader.getController()).setDoua(msg);
            Platform.runLater(() -> Notifications.create()
                    .graphic(notificationView)
                    .hideCloseButton()
                    .hideAfter(Duration.seconds(duration))
                    .onAction(event -> {System.out.println("Notifcation is Closed !");})
                    .position(Pos.BOTTOM_RIGHT).show());
                     Playsound(); // Sound Notification
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void Playsound() {
        MEDIA_PLAYER = new MediaPlayer(new Media(new File("Ressource/mp3/Notification.mp3").toURI().toString()));
        MEDIA_PLAYER.play();
    }
    
    
        public static String RandomGradient() {
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
