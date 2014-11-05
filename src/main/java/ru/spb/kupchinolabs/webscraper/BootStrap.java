/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.apache.commons.cli.*;

import static java.lang.System.err;
import static java.lang.System.out;
import static ru.spb.kupchinolabs.webscraper.Constants.*;

public class BootStrap {

    final static private Options options = constructOptions();

    public static void main(String[] args) {
        out.println("!===============================!");
        out.println("!== Welcome to webscraper 1.0 ==!");
        out.println("!===============================!");

        final CommandLine cmd = cmd(args);

        if (cmd != null) {
            try {
                dispatchProcessing(cmd);
            } catch (Exception e) {
                err.println("------------------------------------------");
                err.println("-- Webscraper has done with some errors --");
                err.println("------------------------------------------");
                e.printStackTrace();
                return;
            }
            out.println("++++++++++++++++++++++++++++++++++++++++");
            out.println("++ Webscraper has done with no errors ++");
            out.println("++++++++++++++++++++++++++++++++++++++++");
        }
    }

    protected static boolean dispatchProcessing(CommandLine cmd) {
        return ScrapController.dispatchProcessing(cmd, options);
    }

    protected static CommandLine cmd(String[] args) {
        try {
            return new BasicParser().parse(options, args);
        } catch (ParseException e) {
            out.println(e.getMessage());
            new HelpFormatter().printHelp(COMMAND_LINE_EXAMPLE, options, true);
            return null;
        }
    }

    private static Options constructOptions() {
        Options options = new Options();
        options.addOption(new Option(WORDS_COUNT_OPTION, false, "count number of provided word(s) occurrences on webpage(s)"));
        options.addOption(new Option(CHARS_COUNT_OPTION, false, "count number of characters of each web page"));
        options.addOption(new Option(SENTENCES_OPTION, false, "extract sentences which contain given words"));
        options.addOption(new Option(VERBOSE_OPTION, false, "output verbosity flag, if on then the output should contains information about time spent on data scraping and data processing"));
        options.addOption(OptionBuilder.withArgName("path")
                .hasArg()
                .withDescription("path to plain text file containing a list of URLs")
                .create(FILE_OPTION));
        options.addOption(OptionBuilder.withArgName("url")
                .hasArg()
                .withDescription("web resources URL")
                .create(URL_OPTION));
        options.addOption(OptionBuilder.withArgName("words")
                .hasArg()
                .withDescription("word or list of words with ',' delimiter")
                .create(WORDS_OPTION));
        return options;
    }
}
