/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.apache.commons.cli.*;

public class BootStrap {

    final static private String help =
            "Please use the following format to run webscraper:\n" +
                    "java –jar scraper.jar <url> [words] <commands>\n" +
                    "where:\n" +
                    "   <url> - web link like http://www.cnn.com of path to file like file:///Users/Vladimir/hireright/webscraper/url.list\n" +
                    "   [words] - comma-separated words to scrap. Non mandatory for command [-c]\n" +
                    "   <commands> - supported\n" +
                    "       –v[erbose]\n" +
                    "       –w[ords count]\n" +
                    "       –c[hars on page]\n" +
                    "       –e[xtract sentences with words]\n";

    public static void main(String[] args) throws ParseException {
        System.out.println("=====================");
        System.out.println("==  webscraper 1.0 ==");
        System.out.println("=====================");

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
                .withDescription("word or list of words with “,” delimiter")
                .create("words"));

        CommandLineParser parser = new BasicParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java –jar scraper-jar-with-dependencies.jar", options, true);
            throw e;
        }

        //TODO next check options and start logic

    }
}
