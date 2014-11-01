webscraper
==========

Console web scraper (http://en.wikipedia.org/wiki/Web_scraping) utility which:
-         accepts as command line parameters:
o   web resources URL or path to plain text file containing a list of URLs
o   data command(s)
o   word (or list of words with “,” delimiter)
o   output verbosity flag,  if on then the output should contains information about time spend on data scraping and data processing (-v)
-         supports the following data processing commands:
o   count number of provided word(s) occurrence on webpage(s) (-w)
o   count number of characters of each web page (-c)
o   extract sentences which contain given words (-e)

Data processing results are printed to output for each web resources separately and for all resources as total.

Command line parameters example for Java implementation:

java –jar scraper.jar http://www.cnn.com Greece,default –v –w –c –e
