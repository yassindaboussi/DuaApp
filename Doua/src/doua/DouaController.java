/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doua;

import service.Notification;
import animatefx.animation.FadeOut;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.text.Utilities;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.PopOver;
import service.Animations;
import static service.Animations.fadeInUp;
import static service.Animations.fadeOut;
import service.JFXDialogTool;
import service.ServiceDoua;
import service.mail;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author yassin
 */
public class DouaController implements Initializable {

    private final String GITHUB = "https://github.com/yassindaboussi";
    private final String FACEBOOK = "https://www.facebook.com/yassdaboussi";
    private final String GMAIL = "mailto:yassin.daboussi@esprit.tn";
    private final String YOUTUBE = "https://www.youtube.com/user/dabyain";
    ///////////////////////////////////////////////////////////////////////////////////
    public static Stage stage = null;
    ServiceDoua doua = new ServiceDoua();
    mail mc = new mail();
    private JFXDialogTool dialogContactUs;
    private JFXDialogTool dialogAboutMe;
    private JFXDialogTool dialogTasbih;
    private static final Stage stagee = new Stage();
    public static final BoxBlur BOX_BLUR_EFFECT = new BoxBlur(3, 3, 3);
    private int DureeDoua = 5;
    private int FirstTime = 0;
    public static String SwitchModeActuel = "White";
    private ObservableList<ServiceDoua> ListDoua;
    /////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label timeLabel;
    public Date date;
    @FXML
    private Label day;
    @FXML
    private JFXButton highFrequency;
    @FXML
    private JFXButton midFrequency;
    @FXML
    private JFXButton lowFrequency;
    @FXML
    private Pane PaneHigh;
    @FXML
    private Pane PaneMid;
    @FXML
    private Pane PaneLow;
    @FXML
    private Pane PaneGrey;
    @FXML
    private Pane PaneDayNow;
    @FXML
    private Pane PaneTimeNow;
    @FXML
    private Pane PaneExitMinimize;
    @FXML
    private Pane PaneSwitchMode;
    @FXML
    private Pane PaneDouaReminder;
    @FXML
    private Label labelTitreDouaReminder;
    @FXML
    private AnchorPane rootDoua;
    @FXML
    private StackPane stckDoua;
    @FXML
    private Pane PaneOpa3;
    @FXML
    private JFXToggleButton SwitchMode;
    @FXML
    private ImageView ModeDark;
    @FXML
    private ImageView ModeWhite;
    private Pane PaneLkol;
    @FXML
    private Pane PaneLoutaniya;
    @FXML
    private JFXTextArea txtMsg;
    @FXML
    private JFXComboBox<String> ComboMailSubject;
    @FXML
    private AnchorPane containerContactUs;
    @FXML
    private Pane btnSetting;
    @FXML
    private Pane btnContactUs;
    @FXML
    private Label settinglabel;
    @FXML
    private Label contactlabel;
    @FXML
    private AnchorPane containerAboutMe;
    @FXML
    private MaterialDesignIconView google;
    @FXML
    private MaterialDesignIconView github;
    @FXML
    private MaterialDesignIconView facebook;
    @FXML
    private MaterialDesignIconView youtube;
    @FXML
    private ImageView Yassin;
    @FXML
    private Text developer;
    @FXML
    private Separator separator2;
    @FXML
    private Separator separator1;

    private int clickedAboutMe = 1;

    private int start;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        doua.fetchData(); //Load Doua
        initClock();
        buildPopOver();
        ComboMailSubject.getItems().addAll("اقتراح", "مشكل", "اخرى");
        ComboMailSubject.setValue("اقتراح");
        setURL(); //Url AboutMe
        RepeatShow();
        startNotClicked();
    }

    public void showDoua() {
        if (doua.ObservableListDoua.isEmpty()) {
            //System.out.println(" empty!");
            return;
        } else {
            // System.out.println("not empty!");
        }
        Platform.runLater(()
                -> {
            try {
                Notification.CreateNotificationMinutes(
                        doua.ObservableListDoua.get(new Random().nextInt(doua.ObservableListDoua.size())).getText(), DureeDoua);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

    }

    private void initClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> { //dd/MM/yyyyy 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            timeLabel.setText(LocalDateTime.now().format(formatter));
            date = new Date();
            String DayNowis = String.valueOf(date.getDay());
            if (DayNowis.equals("0")) {
                day.setText("الأحد");
            }
            if (DayNowis.equals("1")) {
                day.setText("الاثنين");
            }
            if (DayNowis.equals("2")) {
                day.setText("الثلاثاء");
            }
            if (DayNowis.equals("3")) {
                day.setText("الأربعاء");
            }
            if (DayNowis.equals("6")) {
                day.setText("الخميس");
            }
            if (DayNowis.equals("5")) {
                day.setText("الجمعة");
            }
            if (DayNowis.equals("7")) {
                day.setText("السبت");
            }
            day.setAlignment(Pos.CENTER); //center Text
            day.setTextFill(Color.RED);
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }

    @FXML
    private void highFrequencyAction(ActionEvent event) {
        DureeDoua = 5;
        PaneLow.setStyle("-fx-background-color: #EEEEEE;-fx-background-radius: 15px 15px 30px 30px");
        PaneMid.setStyle("-fx-background-color: #EEEEEE;-fx-background-radius: 15px 15px 30px 30px");
        PaneHigh.setStyle("-fx-background-color: linear-gradient(to right top, #FBAB7E 0%, #F7CE68 100%); -fx-background-radius: 15px 15px 30px 30px");
    }

    @FXML
    private void midFrequencyAction(ActionEvent event) {
        DureeDoua = 10;
        PaneHigh.setStyle("-fx-background-color: #EEEEEE;-fx-background-radius: 15px 15px 30px 30px");
        PaneLow.setStyle("-fx-background-color: #EEEEEE;-fx-background-radius: 15px 15px 30px 30px");
        PaneMid.setStyle("-fx-background-color: linear-gradient(to right top, #FBAB7E 0%, #F7CE68 100%); -fx-background-radius: 15px 15px 30px 30px");
    }

    @FXML
    private void lowFrequencyAction(ActionEvent event) {
        DureeDoua = 15;
        PaneHigh.setStyle("-fx-background-color: #EEEEEE;-fx-background-radius: 15px 15px 30px 30px");
        PaneMid.setStyle("-fx-background-color: #EEEEEE;-fx-background-radius: 15px 15px 30px 30px");
        PaneLow.setStyle("-fx-background-color: linear-gradient(to right top, #FBAB7E 0%, #F7CE68 100%); -fx-background-radius: 15px 15px 30px 30px");
    }

    @FXML
    private void StartDoua(ActionEvent event) {
        Platform.runLater(()
                -> {
            try {
                Notification.CreateNotificationSeconds("ستبدء الاشعارات بضهور كل " + DureeDoua + " دقائق", 1.7);
            } catch (Exception ex) {
                //  Logger.error("createControlsFX", ex, getClass().getName() + "showZekr().runLater => createControlsFX()");
                ex.printStackTrace();
            }
        });

        //showDoua();
    }
    
    private void startNotClicked()
    {
            Platform.runLater(()
                -> {
            try {
                Notification.CreateNotificationSeconds("ستبدء الاشعارات بضهور كل " + DureeDoua + " دقائق", 5);
            } catch (Exception ex) {
                //  Logger.error("createControlsFX", ex, getClass().getName() + "showZekr().runLater => createControlsFX()");
                ex.printStackTrace();
            }
        });
    }

    private void RepeatShow() {
        Timeline timelinee = new Timeline();
        timelinee.getKeyFrames().add(new KeyFrame(Duration.minutes(DureeDoua), new EventHandler<ActionEvent>() {
            int count = 0;

            @Override
            public void handle(ActionEvent actionEvent) {
                count++;
                System.out.println("Repeat Duree Dou3a(2) ==>> " + DureeDoua);
                System.out.println("count=>>>" + count);
                showDoua();
            }
        }));
        // Repeat indefinitely until stop() method is called.
        timelinee.setCycleCount(Animation.INDEFINITE);
        timelinee.setAutoReverse(true);
        timelinee.play();
        
    }

    private void buildPopOver() {
        //Build PopOver look and feel
        Label labelhight = new Label("ظهور الاذكار كل 5 دقائق");
        labelhight.setStyle("-fx-padding: 18;-fx-background-color: linear-gradient(to right top, #FBAB7E 0%, #F7CE68 100%);-fx-text-fill: white;-fx-font-weight: bold;");

        Label labelM = new Label("ظهور الاذكار كل 10 دقائق");
        labelM.setStyle("-fx-padding: 18;-fx-background-color: linear-gradient(to right top, #FBAB7E 0%, #F7CE68 100%);-fx-text-fill: white;-fx-font-weight: bold;");

        Label labelLow = new Label("ظهور الاذكار كل 15 دقائق");
        labelLow.setStyle("-fx-padding: 18;-fx-background-color: linear-gradient(to right top, #FBAB7E 0%, #F7CE68 100%);-fx-text-fill: white;-fx-font-weight: bold;");

        //Create PopOver and add look and feel
        PopOver popOverHigh = new PopOver(labelhight);
        PopOver popOverM = new PopOver(labelM);
        PopOver popOverLow = new PopOver(labelLow);

        highFrequency.setOnMouseEntered(mouseEvent -> {
            //Show PopOver when mouse enters label
            popOverHigh.show(highFrequency);
        });
        //  popOver.setCloseButtonEnabled(true);
        highFrequency.setOnMouseExited(mouseEvent -> {
            //Hide PopOver when mouse exits label
            popOverHigh.hide();
        });

        midFrequency.setOnMouseEntered(mouseEvent -> {
            //Show PopOver when mouse enters label
            popOverM.show(midFrequency);
        });
        //  popOver.setCloseButtonEnabled(true);
        midFrequency.setOnMouseExited(mouseEvent -> {
            //Hide PopOver when mouse exits label
            popOverM.hide();
        });

        lowFrequency.setOnMouseEntered(mouseEvent -> {
            //Show PopOver when mouse enters label
            popOverLow.show(lowFrequency);
        });
        //  popOver.setCloseButtonEnabled(true);
        lowFrequency.setOnMouseExited(mouseEvent -> {
            //Hide PopOver when mouse exits label
            popOverLow.hide();
        });

    }

    public static void closeStage() {
        if (stage != null) {
            stage.hide();
        }
    }

    @FXML
    private void ContactClicked(MouseEvent event) {
        rootDoua.setEffect(BOX_BLUR_EFFECT);
        containerContactUs.setVisible(true);
        dialogContactUs = new JFXDialogTool(containerContactUs, stckDoua);

        if (SwitchModeActuel == "Night") {
            txtMsg.getStyleClass().clear();
            txtMsg.getStyleClass().add("text-areaDarkMode");
        } else {
            txtMsg.getStyleClass().clear();
            txtMsg.getStyleClass().add("text-areaWhiteMode");
        }

        dialogContactUs.show();
        dialogContactUs.setOnDialogClosed(ev -> {
            closeStage();
            rootDoua.setEffect(null);
            containerContactUs.setVisible(false);
        });
    }

    @FXML
    private void sendEmail() {
        String msg = txtMsg.getText();
        String Subject = ComboMailSubject.getValue().toString();
        if (Subject == "اقتراح") {
            Subject = "suggestion";
        }
        if (Subject == "مشكل") {
            Subject = "Problem";
        }
        if (Subject == "اخرى") {
            Subject = "other";
        }
        if (msg.isEmpty()) {
            txtMsg.requestFocus();
            Animations.shake(txtMsg);
            return;
        } else {
            mc.sendMail(msg, "dabyain@gmail.com", Subject);
            mc.notificationS("Envoyer votre Email", "Email envoyé avec succée");
        }
    }

    @FXML
    private void CloseContactUs() {
        if (dialogContactUs != null) {
            dialogContactUs.close();
        }
    }

    @FXML
    private void SwitchModeClicked(ActionEvent event) {
        if (SwitchMode.isSelected()) {
            PaneGrey.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%)");
            PaneDayNow.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;");
            PaneTimeNow.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;");
            PaneExitMinimize.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;");
            PaneSwitchMode.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;");
            PaneDouaReminder.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;");
            PaneOpa3.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;");
            PaneLoutaniya.setStyle("-fx-background-color:  linear-gradient(to top, #485461 0%, #28313b 74%);-fx-background-radius: 20px 20px 20px 20px;");
            btnSetting.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);-fx-background-radius:  0px 60px 60px 0px;");
            btnContactUs.setStyle("-fx-background-color:  linear-gradient(to top, #485461 0%, #28313b 74%);-fx-background-radius:  0px 60px 60px 0px;");

            labelTitreDouaReminder.setTextFill(Color.color(0.75, 0.75, 0.75));
            settinglabel.setTextFill(Color.color(0.75, 0.75, 0.75));
            contactlabel.setTextFill(Color.color(0.75, 0.75, 0.75));
            SwitchModeActuel = "Night";
            ModeWhite.setVisible(true);
            ModeDark.setVisible(false);
        } else {
            ModeWhite.setVisible(false);
            ModeDark.setVisible(true);
            SwitchModeActuel = "White";
            PaneGrey.setStyle("-fx-background-color: white;-fx-background-radius:1em;");
            PaneGrey.setStyle("-fx-background-color: white;-fx-background-radius:1em;");
            PaneDayNow.setStyle("-fx-background-color: white;-fx-background-radius:1em;");
            PaneTimeNow.setStyle("-fx-background-color: white;-fx-background-radius:1em;");
            PaneExitMinimize.setStyle("-fx-background-color: white;-fx-background-radius:1em;");
            PaneSwitchMode.setStyle("-fx-background-color: white;-fx-background-radius:1em;");
            PaneDouaReminder.setStyle("-fx-background-color: white;-fx-background-radius:1em;");
            PaneOpa3.setStyle("-fx-background-color: white;-fx-background-radius:1em;");
            PaneLoutaniya.setStyle("-fx-background-color: linear-gradient(to right top, #11998e 0%, #38ef7d 100%);-fx-background-radius: 20px 20px 20px 20px;");
            btnSetting.setStyle("-fx-background-color:   #C9D0D4;-fx-background-radius:  0px 60px 60px 0px;");
            btnContactUs.setStyle("-fx-background-color: #C9D0D4;-fx-background-radius:  0px 60px 60px 0px;");

            labelTitreDouaReminder.setTextFill(Color.BLACK);
            settinglabel.setTextFill(Color.WHITE);
            contactlabel.setTextFill(Color.WHITE);

        }
    }

    @FXML
    private void CloseApp(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void MinimizeApp(MouseEvent event) {
        DouaMain.stage.setIconified(true);
    }

    private void url(String url, Node node) {
        node.setOnMouseClicked(ev -> {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException ex) {
                ex.getStackTrace();
            }
        });
    }

    private void setURL() {
        url(GITHUB, github);
        url(FACEBOOK, facebook);
        url(GMAIL, google);
        url(YOUTUBE, youtube);
    }

    private void setAnimations() {
        transition(developer, 1);
        transition(separator1, 2);
        transition(Yassin, 3);
        transition(separator2, 4);
        transition(facebook, 5);
        transition(youtube, 6);
        transition(github, 7);
        transition(google, 8);
    }

    private void transition(Node node, int duration) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), node);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), node);
        fadeTransition.setFromValue(2);
        fadeTransition.setToValue(0.5);

        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(duration));
        pauseTransition.setOnFinished(ev -> {
            PauseTransition pauseTransition2 = new PauseTransition();
            pauseTransition2.setDuration(Duration.seconds(0.1));
            pauseTransition2.setOnFinished(ev2 -> {
                node.setVisible(true);
            });

            pauseTransition2.play();
            fadeInUp(node);
            fadeTransition.play();
        });

        pauseTransition.play();

        node.setOnMouseEntered(ev -> {
            fadeTransition.setToValue(1);
            fadeTransition.playFromStart();

            scaleTransition.setRate(1.0);
            scaleTransition.play();
        });

        node.setOnMouseExited(ev -> {
            fadeTransition.setDuration(Duration.millis(100));
            fadeTransition.setToValue(0.5);
            fadeTransition.playFromStart();

            scaleTransition.setRate(-1.0);
            scaleTransition.play();
        });
    }

    @FXML
    private void AboutMeClicked(MouseEvent event) {
        rootDoua.setEffect(BOX_BLUR_EFFECT);
        containerAboutMe.setVisible(true);
        dialogAboutMe = new JFXDialogTool(containerAboutMe, stckDoua);
        dialogAboutMe.show();
        if (clickedAboutMe == 1) {
            setAnimations();
        }
        if (clickedAboutMe == 2) {
            fadeInUp(containerAboutMe);
        }
        dialogAboutMe.setOnDialogClosed(ev -> {
            fadeOut(containerAboutMe);
            clickedAboutMe = 2;
            closeStage();
            rootDoua.setEffect(null);
        });
    }

    @FXML
    private void CloseAboutMe() {
        fadeOut(containerAboutMe);
        clickedAboutMe = 2;
        if (dialogAboutMe != null) {
            dialogAboutMe.close();
        }
    }

    @FXML
    private void TasbihClicked(MouseEvent event) {
        rootDoua.setEffect(BOX_BLUR_EFFECT);
        containerContactUs.setVisible(true);
        dialogContactUs = new JFXDialogTool(containerContactUs, stckDoua);

        if (SwitchModeActuel == "Night") {
            txtMsg.getStyleClass().clear();
            txtMsg.getStyleClass().add("text-areaDarkMode");
        } else {
            txtMsg.getStyleClass().clear();
            txtMsg.getStyleClass().add("text-areaWhiteMode");
        }

        dialogContactUs.show();
        dialogContactUs.setOnDialogClosed(ev -> {
            closeStage();
            rootDoua.setEffect(null);
            containerContactUs.setVisible(false);
        });

    }

}
