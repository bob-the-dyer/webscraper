/*
 * Copyright (c) by Kupchino Labs
 * created: 3/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestHtmlUnit {

    @Test(expected = Exception.class)
    public void testCnnCom() throws IOException {
        final WebClient webClient = new WebClient();
        webClient.getPage("http://www.cnn.com");
        fail();
    }

    @Test
    public void testHtmlUnitSourceforgeNet() throws IOException {
        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        final String pageAsText = page.asText();
        assertTrue(pageAsText.contains("It is typically used for testing purposes or to retrieve information from web sites"));
    }

    @Test
    public void testMyUrls() throws IOException {
        final WebClient webClient = new WebClient();

        List<String> goodSites = Arrays.asList(
                "https://www.facebook.com",
                "https://www.google.ru",
                "https://www.twitter.com",
                "http://vk.com/feed",
                "https://www.linkedin.com",
                "http://zenhabits.net",
                "http://en.wikipedia.org/wiki/Web_scraping",
                "http://plugins.jetbrains.com/plugin/7527?pr=idea",
                "https://github.com/bob-the-dyer/webscraper"
        );
        for (String goodSite : goodSites) {
            out.println(((HtmlPage) webClient.getPage(goodSite)).asText());
        }

        List<String> badSites = Arrays.asList(
                "http://www.hireright.com",
                "http://drozd4j.postach.io",
                "http://habrahabr.ru",
                "http://lifehacker.ru",
                "http://fishki.net",
                "http://hh.ru",
                "http://yandex.ru"
        );
        for (String badSite : badSites) {
            try {
                out.println(((HtmlPage) webClient.getPage(badSite)).asText());
                fail();
            } catch (Exception e) {
            }
        }
    }

}
