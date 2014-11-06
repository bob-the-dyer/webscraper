/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import java.util.logging.Logger;

import static java.lang.String.format;

public class CharsCountDumper {

    private final static Logger log = Logger.getLogger(CharsCountDumper.class.getName());

    public void dump(String url, int count) {
        log.info(format("%s has %d characters", url, count));
    }
}
