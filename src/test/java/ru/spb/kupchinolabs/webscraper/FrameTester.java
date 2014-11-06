/*
 * Copyright (c) by Kupchino Labs
 * created: 3/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;

public class FrameTester {

    public static void main(String[] args) throws IOException, AWTException {
        final JEditorPane jep = new JEditorPane();
//        jep.setEnabled(false);
        jep.setPage("http://www.htmlunit.sourceforge.net");

        final JTextArea tf = new JTextArea();
//        tf.setEnabled(false);
        JScrollPane scrollPane1 = new JScrollPane(jep);
        JScrollPane scrollPane2 = new JScrollPane(tf);

        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
        jSplitPane.setDividerLocation(0.5);

        JFrame f = new JFrame("webscraper");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().add(jSplitPane);
        f.setSize(800, 600);
        f.setVisible(true);

        final Robot robot = new Robot();
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);

        jep.requestFocus();

        final Point upperLeftPoint = jep.getVisibleRect().getLocation();

        robot.delay(4000);
        robot.mouseMove(upperLeftPoint.x, upperLeftPoint.y);
        robot.delay(500);

        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(200);

        robot.mouseMove(Integer.MAX_VALUE, Integer.MAX_VALUE);
        robot.delay(500);

        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);

        jep.copy();
        tf.paste();
        System.out.println(tf.getText());
    }
}
