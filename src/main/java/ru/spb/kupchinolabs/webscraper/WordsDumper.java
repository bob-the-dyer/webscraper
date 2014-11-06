/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import java.util.List;
import java.util.logging.Logger;

public class WordsDumper {

    private final static Logger log = Logger.getLogger(WordsDumper.class.getName());

    public void dump(List<ScrapResult> results) {
        for (ScrapResult result : results) {
            final String url = result.getUrl();
            final String word = result.getWord();
            final int count = result.getCount();
            log.info(String.format("%s | %s | %s", url, word, count));
        }
    }

}