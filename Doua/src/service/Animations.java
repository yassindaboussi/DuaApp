/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import animatefx.animation.Bounce;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeInUp;
import animatefx.animation.FadeOut;
import animatefx.animation.Shake;
import javafx.animation.Interpolator;
import static javafx.animation.Interpolator.EASE_BOTH;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.util.Duration;
import animatefx.animation.Swing;
import animatefx.animation.Flash;
import animatefx.animation.RollIn;
import animatefx.animation.Wobble;

public class Animations {

    public static void fadeInUp(Node node) {
        new FadeInUp(node).play();
    }

    public static void shake(Node node) {
        new Shake(node).play();
    }

    public static void fadeOut(Node node) {
        new FadeOut(node).play();
    }

    public static void Bounce(Node node) {
        new Bounce(node).play();
    }

    public static void Swing(Node node) {
        new Swing(node).play();
    }

    public static void Flash(Node node) {
        new Flash(node).play();
    }

    public static void Roll(Node node) {
        new RollIn(node).play();
    }

    public static void Wobble(Node node) {
        new Wobble(node).play();
    }


}
