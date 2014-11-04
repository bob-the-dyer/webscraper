webscraper
==========

Console [web scraper](http://en.wikipedia.org/wiki/Web_scraping) utility which:

1. accepts as command line parameters:

 - web resources URL or path to plain text file containing a list of URLs
 - data command(s)
 - word or list of words with “,” delimiter
 - (not supported) output verbosity flag, if on then the output should contains information about time spent on data scraping and data processing (-v)

2. supports the following data processing commands:

 - count number of provided word(s) occurrences on webpage(s) (-w)
 - count number of characters of each web page (-c)
 - (not supported) extract sentences which contain given words (-e)

3. Data processing results are printed to output for each web resources separately and for all resources as total.

Command line parameters example
-------------------------------

    java -jar webscraper-jar-with-dependencies.jar -url http://en.wikipedia.org/wiki/Web_scraping -words scraping,crawler -v -w -c -e   
    
What webscraper does and does not
------------------------

1. Does not process urls recursively, for traversing all urls web crawler should be used instead, list of pages could be provided in a file instead.
  
2. Does not scrap dynamical pages with Javascript and AJAX.
  
3. Process statical pages with __well-formed HTML only__.  HtmlCleaner could be considered to be plugged in order to convert any html to XML compliant document.
  
4. No authentication and popups handling capabilities.

5. No https support, no cookies support.
  
6. No proxy support at the moment.

7. Uses [HtmlUnit](http://htmlunit.sourceforge.net) under the hood.
  
Build from sources
------------------

    mvn install

Prerequisites
-------------
Maven 3.1.1+

Java 1.8+
