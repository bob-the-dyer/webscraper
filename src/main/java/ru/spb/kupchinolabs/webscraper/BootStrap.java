/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.apache.commons.cli.*;

public class BootStrap {

    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("==  webscraper 1.0 ==");
        System.out.println("=====================");

        final CommandLine cmd = cmd(args);
        if (cmd == null) System.exit(-1);

        //TODO next check options and start logic

    }

    protected static CommandLine cmd(String[] args) {
        Options options = new Options();
        options.addOption(new Option("w", false, "count number of provided word(s) occurrences on webpage(s)"));
        options.addOption(new Option("c", false, "count number of characters of each web page"));
        options.addOption(new Option("e", false, "extract sentences which contain given words"));
        options.addOption(new Option("v", false, "output verbosity flag, if on then the output should contains information about time spent on data scraping and data processing"));
        options.addOption(OptionBuilder.withArgName("path")
                .hasArg()
                .withDescription("path to plain text file containing a list of URLs")
                .create("file"));
        options.addOption(OptionBuilder.withArgName("url")
                .hasArg()
                .withDescription("web resources URL")
                .create("url"));
        options.addOption(OptionBuilder.withArgName("words")
                .hasArg()
                .withDescription("word or list of words with ',' delimiter")
                .create("words"));

        try {
            return new BasicParser().parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java –jar webscraper-jar-with-dependencies.jar", options, true);
            return null;
        }
    }
}
