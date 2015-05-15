(defproject tweet_linkz "0.0.1-SNAPSHOT"
  :description "Cool new project to do things and stuff"
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :profiles {:dev {:dependencies [[midje "1.5.1"]
                                  [twitter-api "0.7.5"]
                                  [environ "1.0.0"]]}}
  :main tweet_linkz.core)


