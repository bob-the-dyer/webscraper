/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

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

    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("==  webscraper 1.0 ==");
        System.out.println("=====================");
        if (args == null || args.length < 2) {
            System.out.println("At least URL, one word or one command should be provided as arguments.\n" + help);
            throw new IllegalArgumentException();
        }
        final String url = args[0];
        if (url == null || url.length() == 0 || (!url.startsWith("http://") && !url.startsWith("file://"))) {
            System.out.println("Url is not specified\n" + help);
            throw new IllegalArgumentException();
        }
        final String arg1 = args[1];
        if (args.length == 2) {
            if ("-c".equalsIgnoreCase(arg1)) {
                System.out.println("Counting the number of chars for url(s)");
                //TODO 1
            } else {
                System.out.println("Words and commands must be specified\n" + help);
                throw new IllegalArgumentException();
            }
        } else {
            final String arg2 = args[2];
            if (args.length == 3) {
                if ("-c".equalsIgnoreCase(arg1) && "-v".equalsIgnoreCase(arg2) || "-c".equalsIgnoreCase(arg2) && "-v".equalsIgnoreCase(arg1)) {
                    System.out.println("Counting the number of chars for url(s) in verbose mode");
                    //TODO 2
                } else {
                    System.out.println("Confusing list of commands\n" + help);
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
