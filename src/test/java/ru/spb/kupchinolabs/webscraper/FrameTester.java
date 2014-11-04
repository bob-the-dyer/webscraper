/*
 * Copyright (c) by Kupchino Labs
 * created: 3/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import javax.swing.*;
import java.awt.*;
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
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(jSplitPane);
        f.setSize(800, 600);
        f.setVisible(true);

        Toolkit.getDefaultToolkit();

        final Robot robot = new Robot();


        jep.copy();       // TODO how to select all
        tf.paste();
        System.out.println(tf.getText());
    }
}
