webscraper
==========

Console [web scraper](http://en.wikipedia.org/wiki/Web_scraping) utility which:

1. accepts as command line parameters:

 - web resource URL 
 - data command(s)
 - word or list of words with “,” delimiter
 - (__not supported yet__) path to plain text file containing a list of URLs

2. supports the following data processing commands:

 - count number of provided word(s) occurrences on webpage(s) (-w)
 - count number of characters of each web page (-c)
 - output verbosity flag (-v), if on then the output should contains information about time spent on data scraping and data processing
 - (__not supported yet__) extract sentences which contain given words (-e)

3. Data processing results are printed to output for each web resources separately and for all resources as total.
    
What webscraper does and does not:
----------------------------------

1. Does not process urls recursively, for traversing all urls web crawler should be used instead, list of pages could be provided in a file instead.
  
2. Does not scrap dynamical pages with Javascript, AJAX and errors on pages.
  
3. Processes statical pages with __well-formed HTML only__ (HtmlCleaner could be considered to be plugged in order to convert any html to XML compliant document later).
  
4. No authentication and popups handling capabilities.

5. No https support, no cookies support.
  
6. No proxy support at the moment.

7. Uses [HtmlUnit](http://htmlunit.sourceforge.net) under the hood.

8. No map/reduce technique at the moment, no any performance optimization. 

9. Runs headless as a pure java console application.                                
  
Prerequisites:
--------------

Internet connection

Maven 3.1.1+ installed 

Java 1.8+ installed

How to build from sources and run:
----------------------------------

    cd webscraper
    mvn -DskipTests=true install
    cd target
    java -jar webscraper-jar-with-dependencies.jar [-c] [-e] [-file <path>] [-url <url>] [-v] [-w] [-words <words>]

Example of command line parameters:
-----------------------------------

    java -jar webscraper-jar-with-dependencies.jar -url http://en.wikipedia.org/wiki/Web_scraping -words scraping,crawler,42 -v -w -c -e   

Open questions:
---------------

1. How to deal with html tags, css and javascript code, because I suppose they should’t be counted as chars or treated as data (skipping them all at the moment)

2. Should the scrapper work with only well-formed statical html sites (i.e. xml compliant), what about Ajax, JavaScript and other dynamical content (not supporting them all at the moment)

3. “Do not use 3rd party libraries” - I always use 3rd parties, who doesn't... Does the point here not to use 3rd party web scraper library or no any libs allowed at all and that’s critical in this test task indeed?

4. Should I use some kind of map-reduce technique to boost performance in case of really big pages or a big number of urls in file. Should I care about performance at all in this test task?

5. Should scraper run headless only or it can open UI on background?
