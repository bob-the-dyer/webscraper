/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import java.util.List;

final public class ScrapingResult {

    final private String url;
    final private String word;
    final private int count;
    final private List<String> sentences;

    public ScrapingResult(String url, String word, int count, List<String> sentences) {
        this.url = url;
        this.word = word;
        this.count = count;
        this.sentences = sentences;
    }

    public String getUrl() {
        return url;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public List<String> getSentences() {
        return sentences;
    }
}
