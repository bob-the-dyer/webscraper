/*
 * Copyright (c) by Kupchino Labs
 * created: 3/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestHeadless {
    @Test
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

        //TODO think about javafx Too

        System.out.println(Toolkit.getDefaultToolkit().getSystemClipboard());


    }
}
