/*
 * Copyright (c) by Kupchino Labs
 * created: 5/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static ru.spb.kupchinolabs.webscraper.Constants.*;

public class ScrapController {

    public static boolean dispatchProcessing(CommandLine cmd, Options options) {
        //TODO verbose
        if (cmd.hasOption(URL_OPTION)) {
            boolean goodOptions = false;
            if (cmd.hasOption(CHARS_COUNT_OPTION)) {
                boolean verbose = false;
                if (cmd.hasOption(VERBOSE_OPTION)) {
                    verbose = true;
                }
                final String url = cmd.getOptionValue(URL_OPTION);
                final int count = new URLCharsCounter().count(url);
                new UrlCharsCountDumper().dump(url, count);
                goodOptions = true;
            }
            if (cmd.hasOption(WORDS_OPTION) && cmd.hasOption(WORDS_COUNT_OPTION)) {
                boolean verbose = false;
                if (cmd.hasOption(VERBOSE_OPTION)) {
                    verbose = true;
                }
                final String url = cmd.getOptionValue(URL_OPTION);
                final String words = cmd.getOptionValue(WORDS_OPTION);
                final List<ScrapResult> results = new UrlWordsScraper().scrap(url, Arrays.asList(words.split(",")));
                new UrlWordsDumper().dump(results);
                goodOptions = true;
            }
            if (!goodOptions) {
                out.println("Either " + WORDS_COUNT_OPTION + " or " + CHARS_COUNT_OPTION + " commands were specified incorrectly.");
                new HelpFormatter().printHelp(COMMAND_LINE_EXAMPLE, options, true);
            }
            return goodOptions;
        } else if (cmd.hasOption(FILE_OPTION)) {
            out.println(FILE_OPTION + " option is not supported yet");
            //TODO logic for file
            return true;
        } else {
            out.println("Neither " + URL_OPTION + " nor " + FILE_OPTION + " commands were specified.");
            new HelpFormatter().printHelp(COMMAND_LINE_EXAMPLE, options, true);
            return false;
        }
    }

}