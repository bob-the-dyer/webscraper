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

public class UrlScraper {

    public List<ScrapingResult> scrap(String url, List<String> words) {
        List<ScrapingResult> results = new LinkedList<>();
        final WebClient webClient = new WebClient();
        final HtmlPage htmlPage;
        try {
            htmlPage = webClient.getPage(url);
        } catch (IOException e) {
            throw new RuntimeException("Page couldn't no be scraped", e);
        }
        final String titleText = htmlPage.getTitleText().toLowerCase();
        final String pageAsText = htmlPage.asText().toLowerCase();
        String page = pageAsText.substring(titleText.length());
        //TODO consider tokenizer to boost performance
        for (String word : words) {
            int wordCount = 0;
            int indexOf = 0;
            final String wordLowerCased = word.toLowerCase();
            while ((indexOf = page.indexOf(wordLowerCased, indexOf)) != -1) {
                wordCount++;
                indexOf += word.length();
            }
            results.add(new ScrapingResult(url, word, wordCount, null));
        }
        return results;
    }
}
