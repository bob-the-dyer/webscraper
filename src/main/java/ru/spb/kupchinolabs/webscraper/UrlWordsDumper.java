/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import java.util.List;

import static java.lang.System.out;

public class UrlWordsDumper {

    public void dump(List<ScrapResult> results) {
        for (ScrapResult result : results) {
            final String url = result.getUrl();
            final String word = result.getWord();
            final int count = result.getCount();
            out.println(String.format("%s | %s | %s", url, word, count));
        }
    }

}