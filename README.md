webscraper
==========

Console [web scraper](http://en.wikipedia.org/wiki/Web_scraping) utility which:

1. accepts as command line parameters:

 - web resources URL or path to plain text file containing a list of URLs
 - data command(s)
 - word or list of words with “,” delimiter
 - (optional) output verbosity flag, if on then the output should contains information about time spent on data scraping and data processing (-v)

2. supports the following data processing commands:

 - count number of provided word(s) occurrences on webpage(s) (-w)
 - count number of characters of each web page (-c)
 - (optional) extract sentences which contain given words (-e)

3. Data processing results are printed to output for each web resources separately and for all resources as total.

Command line parameters example
-------------------------------

    java –jar webscraper-jar-with-dependencies.jar -url http://www.cnn.com -words Greece,default –v –w –c –e

Build from sources
------------------

    mvn install

Prerequisites
-------------
Maven 3.1.1+

Java 1.8+
