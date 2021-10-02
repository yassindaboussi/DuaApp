/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author esprit
 */
public class mail {

    public static void sendMail(String msg, String dest,String subject) {
        try {
            System.out.println("Preparing to send email");
            Properties properties = new Properties();

            //Enable authentication
            properties.put("mail.smtp.auth", "true");
            //Set TLS encryption enabled
            properties.put("mail.smtp.starttls.enable", "true");
            //Set SMTP host
            properties.put("mail.smtp.host", "smtp.gmail.com");
            //Set smtp port
            properties.put("mail.smtp.port", "587");

            //Your gmail address
            String userName = "###############";
            //Your gmail password
            String password = "###############";

            //Create a session with account credentials
            Session session;
            session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(userName, password);
                }
            }
            );

            //Prepare email message
            Message message = prepareMessage(session, userName, dest, msg,subject);
            //Send mail
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (MessagingException ex) {
            ex.getMessage();
        }
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String msg , String subject) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            //  message.setSubject("Notification [Update]");
            message.setSubject("Doua App");
            String htmlCode = "<h3> "+subject+" </h3> <br/> <h2><b>" + msg + "</b></h2>";
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * **********************************************************************************
     */
    public void notificationS(String title, String msg) { //SUCCESS

        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(msg);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
    }

    public void notificationF(String title, String msg) { //ERROR

        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(title);
        tray.setMessage(msg);
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndDismiss(Duration.millis(3000));

    }
   
}
