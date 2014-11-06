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
        final BootStrap bootStrap = new BootStrap();
        assertNotNull(bootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-words", "scraping,mining", "–v", "–w", "–c", "–e"}));
        assertNotNull(bootStrap.cmd(new String[]{"-file", "/Users/url_list.txt", "-words", "Greece", "–w", "–c"}));
    }

    @Test
    public void testUnknownArgs() throws Exception {
        final BootStrap bootStrap = new BootStrap();
        final CommandLine cmd = bootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-swords", "scraping,mining", "–g", "–h", "–m", "–l"});
        assertNull(cmd);
    }

    @Test
    public void testMandatoryCommandsUrlOrFile() throws IOException {
        final BootStrap bootStrap = new BootStrap();
        final CommandLine cmd = bootStrap.cmd(new String[]{"-words", "Greece,default", "–v", "–w", "–c", "–e"});
        assertFalse(bootStrap.dispatchCommands(cmd));
    }

    @Test
    public void testMandatoryCommandsWordsAndCounts() throws IOException {
        final BootStrap bootStrap = new BootStrap();
        CommandLine cmd = bootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-words", "scraping,mining", "-v"});
        assertFalse(bootStrap.dispatchCommands(cmd));
        cmd = bootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-w"});
        assertFalse(bootStrap.dispatchCommands(cmd));
        cmd = bootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-words", "scraping,mining", "-c"});
        assertTrue(bootStrap.dispatchCommands(cmd));
        cmd = bootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-words", "scraping,mining", "-c", "-w"});
        assertTrue(bootStrap.dispatchCommands(cmd));
        cmd = bootStrap.cmd(new String[]{"-url", "http://en.wikipedia.org/wiki/Web_scraping", "-c"});
        assertTrue(bootStrap.dispatchCommands(cmd));
    }
}
