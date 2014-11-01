webscraper
==========

Console web scraper (http://en.wikipedia.org/wiki/Web_scraping) utility which:
1) accepts as command line parameters:
 - web resources URL or path to plain text file containing a list of URLs
 - data command(s)
 - word (or list of words with “,” delimiter)
 - output verbosity flag,  if on then the output should contains information about time spend on data scraping and data processing (-v)
2) supports the following data processing commands:
 - count number of provided word(s) occurrence on webpage(s) (-w)
 - count number of characters of each web page (-c)
 - extract sentences which contain given words (-e)
3) No third-party libraries are used

Data processing results are printed to output for each web resources separately and for all resources as total.

Command line parameters example for Java implementation:

java –jar scraper.jar http://www.cnn.com Greece,default –v –w –c –e
