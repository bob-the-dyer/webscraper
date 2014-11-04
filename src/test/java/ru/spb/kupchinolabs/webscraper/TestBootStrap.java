/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.apache.commons.cli.CommandLine;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBootStrap {

    @Test
    public void testGoodArgs() throws Exception {
        final BootStrap bootStrap = new BootStrap();
        assertNotNull(bootStrap.cmd(new String[]{"-url", "http://www.cnn.com", "-words", "Greece,default", "–v", "–w", "–c", "–e"}));
        assertNotNull(bootStrap.cmd(new String[]{"-file", "/Users/scraper-jar-with-dependencies.jar", "-words", "Greece", "–w", "–c"}));
    }

    @Test
    public void testUnknownArgs() throws Exception {
        final BootStrap bootStrap = new BootStrap();
        final CommandLine cmd = bootStrap.cmd(new String[]{"-url", "http://www.cnn.com", "-swords", "Greece,default", "–g", "–h", "–m", "–l"});
        assertNull(cmd);
    }

    @Test
    public void testMandatoryCommandsUrlOrFile() {
        final BootStrap bootStrap = new BootStrap();
        final CommandLine cmd = bootStrap.cmd(new String[]{"-words", "Greece,default", "–v", "–w", "–c", "–e"});
        assertFalse(bootStrap.dispatchProcessing(cmd));
    }

    @Test
    public void testMandatoryCommandsWordsAndCounts() {
        final BootStrap bootStrap = new BootStrap();
        CommandLine cmd = bootStrap.cmd(new String[]{"-url", "http://www.cnn.com", "-words", "Greece,default", "-v"});
        assertFalse(bootStrap.dispatchProcessing(cmd));
        cmd = bootStrap.cmd(new String[]{"-url", "http://www.cnn.com", "-w"});
        assertFalse(bootStrap.dispatchProcessing(cmd));
        cmd = bootStrap.cmd(new String[]{"-url", "http://www.cnn.com", "-words", "Greece,default", "-c"});
        assertTrue(bootStrap.dispatchProcessing(cmd));
        cmd = bootStrap.cmd(new String[]{"-url", "http://www.cnn.com", "-c"});
        assertTrue(bootStrap.dispatchProcessing(cmd));
    }
}
