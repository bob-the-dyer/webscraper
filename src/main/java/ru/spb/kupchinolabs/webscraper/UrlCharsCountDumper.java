/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import static java.lang.String.format;
import static java.lang.System.out;

public class UrlCharsCountDumper {

    public void dump(String url, int count) {
        out.println(format("%s has %d characters", url, count));
    }
}
