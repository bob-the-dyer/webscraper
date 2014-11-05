/*
 * Copyright (c) by Kupchino Labs
 * created: 3/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.io.IOException;

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
        System.out.println(((HtmlPage) webClient.getPage("https://www.facebook.com")).asText());
        System.out.println(((HtmlPage) webClient.getPage("http://vk.com/feed")).asText());
        System.out.println(((HtmlPage) webClient.getPage("https://www.linkedin.com")).asText());
        System.out.println(((HtmlPage) webClient.getPage("http://zenhabits.net")).asText());
        System.out.println(((HtmlPage) webClient.getPage("http://en.wikipedia.org/wiki/Web_scraping")).asText());
        System.out.println(((HtmlPage) webClient.getPage("http://plugins.jetbrains.com/plugin/7527?pr=idea")).asText());
        System.out.println(((HtmlPage) webClient.getPage("https://github.com/bob-the-dyer/webscraper")).asText());
// BAD       System.out.println(((HtmlPage) webClient.getPage("http://drozd4j.postach.io")).asText());
// BAD       System.out.println(((HtmlPage) webClient.getPage("http://habrahabr.ru")).asText());
// BAD       System.out.println(((HtmlPage) webClient.getPage("http://lifehacker.ru")).asText());
// BAD       System.out.println(((HtmlPage) webClient.getPage("http://fishki.net")).asText());
    }

}
