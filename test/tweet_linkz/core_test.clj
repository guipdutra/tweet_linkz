(ns tweet_linkz.core-test
  (:use midje.sweet)
  (:use [tweet_linkz.core]))

(facts "about `extract-link`"
       (fact "it returns the link inside the text"
             (extract-link "Some text and http://www.google.com some text.") => "http://www.google.com"
             (extract-link "Some text and http://www.google.com.") => "http://www.google.com")
       (fact "it returns nil when does not have a link on text"
             (extract-link "Some text") => nil))
