/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.apache.commons.cli.*;

public class BootStrap {

    public static final String WORDS_COUNT_OPTION = "w";
    public static final String CHARS_COUNT_OPTION = "c";
    public static final String SENTENCES_OPTION = "e";
    public static final String VERBOSE_OPTION = "v";
    public static final String FILE_OPTION = "file";
    public static final String URL_OPTION = "url";
    public static final String WORDS_OPTION = "words";
    public static final String COMMAND_LINE_EXAMPLE = "java -jar webscraper-jar-with-dependencies.jar";

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("==  Welcome to webscraper 1.0 ==");
        System.out.println("================================");

        final CommandLine cmd = cmd(args);

        if (cmd != null) {
            dispatchProcessing(cmd);
        }
    }

    protected static boolean dispatchProcessing(CommandLine cmd) {
        if (cmd.hasOption(URL_OPTION)) {
            boolean goodOptions = false;
            if (cmd.hasOption(WORDS_OPTION) && cmd.hasOption(WORDS_COUNT_OPTION)) {
                //TODO logic for url and words counting
                goodOptions = true;
            }
            if (cmd.hasOption(CHARS_COUNT_OPTION)) {
                //TODO logic for url and chars counting
                goodOptions = true;
            }
            if (!goodOptions) {
                System.out.println("Either " + WORDS_COUNT_OPTION + " or " + CHARS_COUNT_OPTION + " commands were specified incorrectly.");
                new HelpFormatter().printHelp(COMMAND_LINE_EXAMPLE, constructOptions(), true);
            }
            return goodOptions;
        } else if (cmd.hasOption(FILE_OPTION)) {
            System.out.println(FILE_OPTION + " option is not supported yet");
            //TODO logic for file
            return true;
        } else {
            System.out.println("Neither " + URL_OPTION + " nor " + FILE_OPTION + " commands were specified.");
            new HelpFormatter().printHelp(COMMAND_LINE_EXAMPLE, constructOptions(), true);
            return false;
        }
    }

    protected static CommandLine cmd(String[] args) {
        Options options = constructOptions();
        try {
            return new BasicParser().parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
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
