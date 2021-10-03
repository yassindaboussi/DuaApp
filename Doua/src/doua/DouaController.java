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
import com.jfoenix.controls.JFXMasonryPane;
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
import java.util.Arrays;
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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TabPane;
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
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

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
    private final JFXMasonryPane mansoryPane = new JFXMasonryPane();
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
    @FXML
    private AnchorPane containerTasbih;
    private int id = 0;
    @FXML
    private TabPane TabPaneRec;

    private int countTasbih1 = 100;
    private int countTasbih2 = 100;
    private int countTasbih3 = 100;
    private int countTasbih4 = 100;
    private int countTasbih5 = 100;
    @FXML
    private Label txtCountTasbih1;
    @FXML
    private Label txtCountTasbih2;
    @FXML
    private Label txtCountTasbih3;
    @FXML
    private Label txtCountTasbih4;
    @FXML
    private Label txtCountTasbih5;
    @FXML
    private Label textDoua1;
    @FXML
    private Label textDoua11;
    @FXML
    private Label textDoua111;
    @FXML
    private Label textDoua1111;
    @FXML
    private Label textDoua11111;
    @FXML
    private Label textTeshbih1;
    @FXML
    private Label textTeshbih2;
    @FXML
    private Label textTeshbih3;
    @FXML
    private Label textTeshbih4;
    @FXML
    private Label textTeshbih5;
    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private VBox vbox3;
    @FXML
    private VBox vbox4;
    @FXML
    private VBox vbox5;
    @FXML
    private Pane PaneTasbih1;
    @FXML
    private Pane PaneTasbih2;
    @FXML
    private Pane PaneTasbih3;
    @FXML
    private Pane PaneTasbih4;
    @FXML
    private Pane PaneTasbih5;

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
        //initMansoryCard();
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

    private void startNotClicked() {
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

            textTeshbih1.setTextFill(Color.color(0.75, 0.75, 0.75));
            textTeshbih2.setTextFill(Color.color(0.75, 0.75, 0.75));
            textTeshbih3.setTextFill(Color.color(0.75, 0.75, 0.75));
            textTeshbih4.setTextFill(Color.color(0.75, 0.75, 0.75));
            textTeshbih5.setTextFill(Color.color(0.75, 0.75, 0.75));
            vbox1.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);");
            vbox2.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);");
            vbox3.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);");
            vbox4.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);");
            vbox5.setStyle("-fx-background-color:  linear-gradient(to bottom, #485461 0%, #28313b 74%);");
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

            textTeshbih1.setTextFill(Color.BLACK);
            textTeshbih2.setTextFill(Color.BLACK);
            textTeshbih3.setTextFill(Color.BLACK);
            textTeshbih4.setTextFill(Color.BLACK);
            textTeshbih5.setTextFill(Color.BLACK);
            vbox1.setStyle("-fx-background-color:  #F7F7F7;");
            vbox2.setStyle("-fx-background-color:  #F7F7F7;");
            vbox3.setStyle("-fx-background-color:  #F7F7F7;");
            vbox4.setStyle("-fx-background-color:  #F7F7F7;");
            vbox5.setStyle("-fx-background-color:  #F7F7F7;");

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

    ///////// Card
//    private void initMansoryCard() {
//        mansoryPane.setPadding(new Insets(15, 15, 15, 15));
//        mansoryPane.setVSpacing(5);
//        mansoryPane.setHSpacing(5);
//        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//        scrollPane.setFitToWidth(true);
//        scrollPane.setContent(mansoryPane);
//    }
//    private void loadCarte() {
//        mansoryPane.getChildren().clear();
//        // List<ServiceDoua> listeUser = new ArrayList<>();
//        // listeUser = doua.AfficherAllDoua();
//
//        List<String> listeUser = Arrays.asList("aaaaaaaaaaaa", "cccccccccccccc", "ddddddddddddd", "aaaaaaaaaaaa");
//
//        if (!listeUser.isEmpty()) {
//            for (int i = 0; i < listeUser.size(); i++) {
//                VBox root = new VBox();
//                String dua = listeUser.get(i);
//                root.setPadding(new Insets(12, 17, 17, 17));
//                root.setSpacing(13);
//                id++;
//                ImageView NotVerified, Verified;
//                NotVerified = new ImageView(new Image("img/night.png"));
//                NotVerified.setFitHeight(30);
//                NotVerified.setFitWidth(30);
//                Verified = new ImageView(new Image("img/minimize.png"));
//                Verified.setFitHeight(30);
//                Verified.setFitWidth(30);
//                HBox managebtn = new HBox(NotVerified, Verified);
//
//                root.setStyle("-fx-background-color:  linear-gradient(to right top, #EB3349 , #F45C43); -fx-background-radius: 15px;-fx-effect:dropshadow(three-pass-box, gray, 10, 0, 0, 0);");
//                root.getChildren().addAll(new Label("Dua : " + dua), new Label("id : " + id), managebtn);
//                root.setAlignment(Pos.CENTER);
//                mansoryPane.getChildren().add(root);
//
//                Animations.fadeInUp(mansoryPane);
//
//                NotVerified.setOnMouseClicked((MouseEvent event) -> {
//                    System.out.println("icon NotVerified is pressed !");
//                    System.out.println("id ==>> " + id);
//                });
//
//                Verified.setOnMouseClicked((MouseEvent event) -> {
//                    System.out.println("icon Verified is pressed !");
//                    System.out.println("id ==>> " + id);
//                });
//
//                root.setOnMouseClicked(ev -> {
//                    System.out.println("Cared  is pressed !");
//
//                });
//
//            }
//
//        }
//
//    }
    @FXML
    private void TasbihClicked(MouseEvent event) {
        rootDoua.setEffect(BOX_BLUR_EFFECT);
        containerTasbih.setVisible(true);
        dialogTasbih = new JFXDialogTool(containerTasbih, stckDoua);
        //loadCarte();
        dialogTasbih.show();
        dialogTasbih.setOnDialogClosed(ev -> {
            closeStage();
            rootDoua.setEffect(null);
            containerTasbih.setVisible(false);
        });
    }

    @FXML
    private void CloseTasbih(MouseEvent event) {
        if (dialogTasbih != null) {
            dialogTasbih.close();
        }
    }

    @FXML
    private void imgCount1Clicked(MouseEvent event) {
        String RandomGradient = Notification.RandomGradient();
        countTasbih1--;
        txtCountTasbih1.setText(String.valueOf(countTasbih1));
        txtCountTasbih1.setAlignment(Pos.CENTER); //center Text
        PaneTasbih1.setStyle(RandomGradient);

        if (String.valueOf(countTasbih1).equals("1")) {
            countTasbih1 = 100;
            txtCountTasbih1.setText(String.valueOf("100"));
        }
    }

    @FXML
    private void imgCount2Clicked(MouseEvent event) {
        String RandomGradient = Notification.RandomGradient();
        countTasbih2--;
        txtCountTasbih2.setText(String.valueOf(countTasbih2));
        txtCountTasbih2.setAlignment(Pos.CENTER); //center Text
        
        PaneTasbih2.setStyle(RandomGradient);
        if (String.valueOf(countTasbih2).equals("1")) {
            countTasbih2 = 100;
            txtCountTasbih2.setText(String.valueOf("100"));
        }
    }

    @FXML
    private void imgCount3Clicked(MouseEvent event) {
        String RandomGradient = Notification.RandomGradient();
        countTasbih3--;
        txtCountTasbih3.setText(String.valueOf(countTasbih3));
        txtCountTasbih3.setAlignment(Pos.CENTER); //center Text
        
        PaneTasbih3.setStyle(RandomGradient);
        if (String.valueOf(countTasbih3).equals("1")) {
            countTasbih3 = 100;
            txtCountTasbih3.setText(String.valueOf("100"));
        }
    }

    @FXML
    private void imgCount4Clicked(MouseEvent event) {
        String RandomGradient = Notification.RandomGradient();
        countTasbih4--;
        txtCountTasbih4.setText(String.valueOf(countTasbih4));
        txtCountTasbih4.setAlignment(Pos.CENTER); //center Text
        
        PaneTasbih4.setStyle(RandomGradient);
        if (String.valueOf(countTasbih4).equals("1")) {
            countTasbih4 = 100;
            txtCountTasbih4.setText(String.valueOf("100"));
        }
    }

    @FXML
    private void imgCount5Clicked(MouseEvent event) {
        String RandomGradient = Notification.RandomGradient();
        countTasbih5--;
        txtCountTasbih5.setText(String.valueOf(countTasbih5));
        txtCountTasbih5.setAlignment(Pos.CENTER); //center Text
        
        PaneTasbih5.setStyle(RandomGradient);
        if (String.valueOf(countTasbih5).equals("1")) {
            countTasbih5 = 100;
            txtCountTasbih5.setText(String.valueOf("100"));
        }
    }

    public static void copyToClipboard(String text) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(text), null);
    }

    @FXML
    private void CopyTasbih1(MouseEvent event) {
        copyToClipboard(textTeshbih1.getText() + "\n" + textDoua1.getText());
    }

    @FXML
    private void CopyTasbih2(MouseEvent event) {
        copyToClipboard(textTeshbih2.getText() + "\n" + textDoua11.getText());

    }

    @FXML
    private void CopyTasbih3(MouseEvent event) {
        copyToClipboard(textTeshbih3.getText() + "\n" + textDoua111.getText());

    }

    @FXML
    private void CopyTasbih4(MouseEvent event) {
        copyToClipboard(textTeshbih4.getText() + "\n" + textDoua1111.getText());

    }

    @FXML
    private void CopyTasbih5(MouseEvent event) {
        copyToClipboard(textTeshbih5.getText() + "\n" + textDoua11111.getText());

    }

}
