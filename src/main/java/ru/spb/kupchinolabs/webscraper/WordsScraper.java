/*
 * Copyright (c) by Kupchino Labs
 * created: 4/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import static java.lang.String.format;

public class WordsScraper {

    static { //disabling logging for HtmlUnit
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }

    public List<ScrapResult> scrap(String url, List<String> words) {
        List<ScrapResult> results = new LinkedList<>();
        final WebClient webClient = new WebClient();
        final HtmlPage htmlPage;
        try {
            htmlPage = webClient.getPage(url);
        } catch (IOException e) {
            throw new RuntimeException(format("Page %s couldn't no be scraped", url), e);
        }
        final String titleText = htmlPage.getTitleText().toLowerCase();
        final String pageAsText = htmlPage.asText().toLowerCase();
        String page = pageAsText.substring(titleText.length());

        //TODO consider tokenizer to boost performance and search all words within single iteration

        for (String word : words) {
            int wordCount = 0;
            int indexOf = 0;
            final String wordLowerCased = word.toLowerCase();
            while ((indexOf = page.indexOf(wordLowerCased, indexOf)) != -1) {
                wordCount++;
                indexOf += word.length();
            }
            results.add(new ScrapResult(url, word, wordCount, null));
        }
        return results;
    }
}
