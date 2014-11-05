/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestUrlScrapper {
    @Test
    public void testWikiPage() {
        final List<ScrapResult> scrap = new UrlWordsScraper().scrap("http://en.wikipedia.org/wiki/Web_scraping", Arrays.asList("scraping", "Mining", "Crawler", "bible"));
        assertEquals(34, scrap.get(0).getCount());
        assertEquals(2,  scrap.get(1).getCount());
        assertEquals(2,  scrap.get(2).getCount());
        assertEquals(0,  scrap.get(3).getCount());
    }
}
