(ns clojure-bank.entrypoint.about-entrypoint
  (:require [ring.util.response :as ring-resp]))

(defn about-page
  [_]
  (ring-resp/response {:version (clojure-version)
                       :route ::about-page}))
