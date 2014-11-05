/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.logging.Level;

import static java.lang.String.format;

public class URLCharsCounter {

    static { //disabling loggin for HtmlUnit
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }

    public int count(String url) {
        final WebClient webClient = new WebClient();
        final HtmlPage htmlPage;
        try {
            htmlPage = webClient.getPage(url);
        } catch (IOException e) {
            throw new RuntimeException(format("Page %s couldn't no be scraped", url), e);
        }
        return htmlPage.asText().length() - htmlPage.getTitleText().length();
    }

}
