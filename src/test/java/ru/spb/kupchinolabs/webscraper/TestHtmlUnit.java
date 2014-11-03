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

}
