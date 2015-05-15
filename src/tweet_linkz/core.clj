(ns tweet_linkz.core
  (:use
    [twitter.oauth]
    [twitter.callbacks]
    [twitter.callbacks.handlers]
    [twitter.api.restful])
  (:import
    (twitter.callbacks.protocols SyncSingleCallback))
  (require [environ.core :refer [env]]))

(def my-tokens
  (env :env))

(def my-creds (make-oauth-creds (my-tokens :consumer_key)
                                (my-tokens :consumer_secret)
                                (my-tokens :access_token)
                                (my-tokens :access_token_secret)))

(defn extract-link
  [tweet]
  (re-find #"http://\S+[^\W]" tweet))

(def timeline-tweets
  (map :text (statuses-home-timeline :oauth-creds my-creds
                                       :params {:count 2}
                                       :callbacks (SyncSingleCallback. response-return-body
                                                                       response-throw-error
                                                                       exception-rethrow))))
(defn get-links-from-tweets
  [tweets]
  (remove nil? (map #(extract-link %) tweets)))

(defn -main
  []
  (dorun
    (map #(println %) (get-links-from-tweets timeline-tweets))))
