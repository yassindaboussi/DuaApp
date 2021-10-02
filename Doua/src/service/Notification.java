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

}
