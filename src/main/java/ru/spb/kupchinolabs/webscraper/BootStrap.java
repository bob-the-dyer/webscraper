/*
 * Copyright (c) by Kupchino Labs
 * created: 1/11/2014 (dd/MM/yyyy)
 * author: Vladimir Krasilschik
 */

package ru.spb.kupchinolabs.webscraper;

import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.lang.System.out;
import static ru.spb.kupchinolabs.webscraper.Constants.*;

public class BootStrap {

    final static private Options options = constructOptions();

    public static void main(String[] args) throws IOException {

        LogManager.getLogManager().readConfiguration(BootStrap.class.getResourceAsStream("/logging.properties"));

        final Logger log = Logger.getLogger(BootStrap.class.getName());

        log.info("Welcome to webscraper v0.8");

        final CommandLine cmd = cmd(args);

        if (cmd != null) {
            try {
                dispatchCommands(cmd);
            } catch (Exception e) {
                log.warning("Webscraper v0.8 has done with some errors");
                log.warning(e.getMessage());
                return;
            }
            log.info("Webscraper v0.8 has done with no errors");
        }
    }

    protected static boolean dispatchCommands(CommandLine cmd) {
        return CommandsDispatcher.dispatch(cmd, options);
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
