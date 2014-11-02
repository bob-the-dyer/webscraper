/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.Test;

public class TestBootStrap {

    @Test()
    public void testGoodArgs() throws Exception {
        new BootStrap().main(new String[]{"-url", "http://www.cnn.com", "-words", "Greece,default", "–v", "–w", "–c", "–e"});
        new BootStrap().main(new String[]{"-file", "/Users/scraper-jar-with-dependencies.jar", "-words", "Greece", "–w", "–c"});
    }

    @Test(expected = UnrecognizedOptionException.class)
    public void testUnknownArgs() throws Exception {
        new BootStrap().main(new String[]{"-url", "http://www.cnn.com", "-swords", "Greece,default", "–g", "–h", "–m", "–l"});
    }
}
