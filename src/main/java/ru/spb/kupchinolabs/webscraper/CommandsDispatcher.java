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
import java.util.logging.Logger;

import static java.lang.String.format;
import static ru.spb.kupchinolabs.webscraper.Constants.*;

public class CommandsDispatcher {

    private final static Logger log = Logger.getLogger(CommandsDispatcher.class.getName());

    public static boolean dispatch(CommandLine cmd, Options options) {
        boolean verbose = cmd.hasOption(VERBOSE_OPTION);
        final long start = System.currentTimeMillis();
        if (cmd.hasOption(URL_OPTION)) {
            if (cmd.hasOption(SENTENCES_OPTION)){
                log.warning(SENTENCES_OPTION + " option is not supported yet");
                //TODO logic for sentences
            }
            boolean goodOptions = false;
            if (cmd.hasOption(CHARS_COUNT_OPTION)) {
                final String url = cmd.getOptionValue(URL_OPTION);
                final int count = new CharsCounter().count(url);
                new CharsCountDumper().dump(url, count);
                goodOptions = true;
            }
            if (cmd.hasOption(WORDS_OPTION) && cmd.hasOption(WORDS_COUNT_OPTION)) {
                final String url = cmd.getOptionValue(URL_OPTION);
                final String words = cmd.getOptionValue(WORDS_OPTION);
                final List<ScrapResult> results = new WordsScraper().scrap(url, Arrays.asList(words.split(",")));
                new WordsDumper().dump(results);
                goodOptions = true;
            }
            if (!goodOptions) {
                log.severe("Either " + WORDS_COUNT_OPTION + " or " + CHARS_COUNT_OPTION + " commands were specified incorrectly.");
                new HelpFormatter().printHelp(COMMAND_LINE_EXAMPLE, options, true);
            } else {
                if (verbose) {
                    log.info(format("Scraping and processing has taken %d millis", System.currentTimeMillis() - start));
                }
            }
            return goodOptions;
        } else if (cmd.hasOption(FILE_OPTION)) {
            log.warning(FILE_OPTION + " option is not supported yet");
            //TODO logic for file
            return true;
        } else {
            log.severe("Neither " + URL_OPTION + " nor " + FILE_OPTION + " commands were specified.");
            new HelpFormatter().printHelp(COMMAND_LINE_EXAMPLE, options, true);
            return false;
        }
    }

}