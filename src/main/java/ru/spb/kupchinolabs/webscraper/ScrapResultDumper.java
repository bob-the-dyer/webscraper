/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import java.util.List;

public class ScrapResultDumper {

    public void dump(List<ScrapResult> results) {
        for (ScrapResult result : results) {
            final String delim = " | ";
            final String url = result.getUrl();
            final String word = result.getWord();
            final int count = result.getCount();
            System.out.println(url + delim + word + delim + count);
        }
    }

}