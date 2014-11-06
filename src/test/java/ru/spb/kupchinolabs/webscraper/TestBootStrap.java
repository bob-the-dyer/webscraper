/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.apache.commons.cli.CommandLine;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestBootStrap {

    @Test
    public void testGoodArgs() throws Exception {
        assertNotNull(BootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-words", "scraping,mining", "–v", "–w", "–c", "–e"}));
        assertNotNull(BootStrap.cmd(new String[]{"-file", "/Users/url_list.txt", "-words", "Greece", "–w", "–c"}));
    }

    @Test
    public void testUnknownArgs() throws Exception {
        final CommandLine cmd = BootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-swords", "scraping,mining", "–g", "–h", "–m", "–l"});
        assertNull(cmd);
    }

    @Test
    public void testMandatoryCommandsUrlOrFile() throws IOException {
        final CommandLine cmd = BootStrap.cmd(new String[]{"-words", "Greece,default", "–v", "–w", "–c", "–e"});
        assertFalse(BootStrap.dispatchCommands(cmd));
    }

    @Test
    public void testMandatoryCommandsWordsAndCounts() throws IOException {
        CommandLine cmd = BootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-words", "scraping,mining", "-v"});
        assertFalse(BootStrap.dispatchCommands(cmd));
        cmd = BootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-w"});
        assertFalse(BootStrap.dispatchCommands(cmd));
        cmd = BootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-words", "scraping,mining", "-c"});
        assertTrue(BootStrap.dispatchCommands(cmd));
        cmd = BootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-words", "scraping,mining", "-c", "-w"});
        assertTrue(BootStrap.dispatchCommands(cmd));
        cmd = BootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-c"});
        assertTrue(BootStrap.dispatchCommands(cmd));
    }
}
