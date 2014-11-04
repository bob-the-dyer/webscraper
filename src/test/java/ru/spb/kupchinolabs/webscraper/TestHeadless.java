/*
 * Copyright (c) by Kupchino Labs
 * created: 3/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertTrue;

public class TestHeadless {
    @Test(expected = HeadlessException.class)
    public void testHeadlessPanel() throws IOException {
        System.setProperty("java.awt.headless", "true");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        assertTrue(ge.isHeadless());

        final Panel panel = new Panel();
        final JEditorPane pane = new JEditorPane();
        pane.setEnabled(false);
        pane.setPage("http://www.htmlunit.sourceforge.net");
        panel.add(pane);
        pane.copy();

        System.out.println(Toolkit.getDefaultToolkit().getSystemClipboard());
    }

    @Test
    public void testWebEngine() {
        final Stage stage = null;
        System.setProperty("java.awt.headless", "true");
        JFXPanel fxPanel = new JFXPanel();
        CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(
                new Runnable() {
                    @Override
                    public void run() {
                        final WebView webView = new WebView();
                        final WebEngine webEngine = webView.getEngine();
                        webEngine.getLoadWorker().stateProperty().addListener(
                                new ChangeListener<Worker.State>() {
                                    @Override
                                    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                                        if (newValue == Worker.State.SUCCEEDED) {
                                            System.out.println(webEngine.getDocument());
                                            //TODO process DOM?
                                            latch.countDown();
                                        }
                                    }
                                });
                        webEngine.load("http://javafx.com");
                    }
                }
        );
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
