/*
 * Copyright (c) by Kupchino Labs
 * created: 4/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class WordsScraper {

    public List<ScrapResult> scrap(String url, List<String> words) {
        final WebClient webClient = new WebClient();
        final HtmlPage htmlPage;
        try {
            htmlPage = webClient.getPage(url);
        } catch (Exception e) {
            throw new RuntimeException(format("Page %s couldn't be scraped", url), e);
        }
        final String titleText = htmlPage.getTitleText().toLowerCase();
        final String pageAsText = htmlPage.asText().toLowerCase();
        String page = pageAsText.substring(titleText.length());

        return words.stream()
                .map(String::toLowerCase)
                .map(word -> {
                    int wordCount = 0;
                    int indexOf = 0;
                    while ((indexOf = page.indexOf(word, indexOf)) != -1) {
                        wordCount++;
                        indexOf += word.length();
                    }
                    return new ScrapResult(url, word, wordCount, null);
                })
                .collect(Collectors.toCollection(LinkedList::new));
    }
}