/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import static java.lang.String.format;

public class CharsCounter {

    public int count(String url) {
        final WebClient webClient = new WebClient();
        final HtmlPage htmlPage;
        try {
            htmlPage = webClient.getPage(url);
        } catch (Exception e) {
            throw new RuntimeException(format("Page %s couldn't be scraped", url), e);
        }
        return htmlPage.asText().length() - htmlPage.getTitleText().length();
    }

}
