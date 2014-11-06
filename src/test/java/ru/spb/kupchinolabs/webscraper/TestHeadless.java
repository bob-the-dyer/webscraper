/*
 * Copyright (c) by Kupchino Labs
 * created: 3/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import de.saxsys.javafx.test.JfxRunner;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertTrue;

@RunWith(JfxRunner.class)
@Ignore("looks like headless awt is not our case")
public class TestHeadless {
    @Test(expected = HeadlessException.class)
    public void testHeadlessPanel() throws IOException {
        System.setProperty("java.awt.headless", "true");
        assertTrue(GraphicsEnvironment.isHeadless());

        final Panel panel = new Panel();
        final JEditorPane pane = new JEditorPane();
        pane.setEnabled(false);
        pane.setPage("http://www.htmlunit.sourceforge.net");
        panel.add(pane);
        pane.copy();

        System.out.println(Toolkit.getDefaultToolkit().getSystemClipboard());
    }

    @Test(expected = AWTException.class)
    public void testHeadlessRobot() throws AWTException {
        System.setProperty("java.awt.headless", "true");
        final Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
    }

    @Test
    public void testWebEngine() {
        System.setProperty("java.awt.headless", "true");
        CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            new JFXPanel();
            final WebView webView = new WebView();
            final WebEngine webEngine = webView.getEngine();
            webEngine.getLoadWorker().stateProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        if (newValue == Worker.State.SUCCEEDED) {
                            System.out.println(webEngine.getDocument());
                            //TODO process DOM?
                            latch.countDown();
                        }
                    });
            webEngine.load("http://javafx.com");
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}