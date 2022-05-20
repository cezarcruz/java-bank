(ns clojure-bank.entrypoint.home-entrypoint
  (:require [ring.util.response :as ring-resp]))

(defn home-page
  "This is my home page"
  [_]
  (ring-resp/response "Hello World!"))
