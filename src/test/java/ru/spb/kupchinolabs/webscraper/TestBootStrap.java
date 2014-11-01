/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.junit.Test;

public class TestBootStrap {
    @Test(expected = IllegalArgumentException.class)
    public void emptyArgs() {
        new BootStrap().main(new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEnoughArgs() {
        new BootStrap().main(new String[]{"-c"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void noUrlInArgs() {
        new BootStrap().main(new String[]{"Greece,default", "-c"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void noWordsAndNoCharCountCommand() {
        new BootStrap().main(new String[]{"http://cnn.com", "-w"});
    }

    @Test
    public void noWordsAndCharCountCommand() {
        new BootStrap().main(new String[]{"http://cnn.com", "-c"});
    }

    @Test
    public void noWordsAndCharCountCommandWithVerbose() {
        new BootStrap().main(new String[]{"http://cnn.com", "-c", "-v"});
        new BootStrap().main(new String[]{"http://cnn.com", "-v", "-c"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void noWordsAndCharCountCommandWithWordsCounting() {
        new BootStrap().main(new String[]{"http://cnn.com", "-c", "-w"});
    }
}
