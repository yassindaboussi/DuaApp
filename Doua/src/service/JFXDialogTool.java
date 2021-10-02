/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.jfoenix.controls.JFXDialog;
import static com.jfoenix.controls.JFXDialog.DialogTransition.CENTER;
import com.jfoenix.controls.events.JFXDialogEvent;
import static doua.DouaController.SwitchModeActuel;
import javafx.scene.layout.Background;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.event.EventHandler;

public class JFXDialogTool {

    private final JFXDialog dialog;

    public JFXDialogTool(Region region, StackPane container) {
        dialog = new JFXDialog();
        dialog.setContent(region);
        dialog.setBackground(Background.EMPTY);
        dialog.setDialogContainer(container);
        if (SwitchModeActuel.equals("White")) {
            dialog.getStyleClass().add("jfx-dialog-overlay-paneWhite");
        } else {
            dialog.getStyleClass().add("jfx-dialog-overlay-paneBlack");
        }
        dialog.setTransitionType(CENTER);
    }

    public void setOnDialogOpened(EventHandler<JFXDialogEvent> action) {
        dialog.setOnDialogOpened(action);
    }

    public void setOnDialogClosed(EventHandler<JFXDialogEvent> action) {
        dialog.setOnDialogClosed(action);
    }

    public void show() {
        dialog.show();
    }

    public void close() {
        dialog.close();
    }
}
